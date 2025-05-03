/**
 * @author Thierry VAIRA
 * @author Jules HILLION
 * @file BaseDeDonnees.java
 * @brief La classe assurant la gestion de la base de données SQLite
 */

package fr.red.japanlearn.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.red.japanlearn.utils.Question;
import fr.red.japanlearn.utils.mistake.MistakeData;
import fr.red.japanlearn.utils.session.CharType;

@SuppressWarnings({ "SpellCheckingInspection", "unused", "SdCardPath" })
public class DataBase extends SQLiteOpenHelper
{
    private static final String fileName = "japanlearn.db";

    private static DataBase dataBase;

    public static void init(Context context) {
        dataBase = new DataBase(context);
    }

    public static DataBase getDataBase() {
        return dataBase;
    }

    private final SQLiteDatabase sqlite;

    public DataBase(Context context)
    {
        super(context, fileName, null, 1);
        new DBCopier(fileName, context).checkDatabase();
        this.sqlite = this.getWritableDatabase();
    }

    public MistakeData addMistake(@NonNull Question question, String wrongAnswer) {
        String reversedFlag = question.isReversed() ? "1" : "0";
        String idMixUp = getQuestionsIDFrom(wrongAnswer, question.isReversed());

        String query = "INSERT INTO mistakes (idQuestion, idMixUpQuestions, wrongAnswer, reversed) VALUES (" + question.getIDQuestion() + ", ?, ?, " + reversedFlag + ")";
        sqlite.execSQL(query, new Object[]{ idMixUp, wrongAnswer });

        Cursor cursor = sqlite.rawQuery("SELECT * FROM mistakes ORDER BY idMistake DESC LIMIT 1", null);
        cursor.moveToNext();
        int idMistake = cursor.getInt(cursor.getColumnIndexOrThrow("idMistake"));
        int idQuestion = cursor.getInt(cursor.getColumnIndexOrThrow("idQuestion"));
        String idMixUpQuestionsStr = cursor.getString(cursor.getColumnIndexOrThrow("idMixUpQuestions"));
        int count = cursor.getInt(cursor.getColumnIndexOrThrow("count"));
        boolean reversed = cursor.getInt(cursor.getColumnIndexOrThrow("reversed")) == 1;
        cursor.close();

        return new MistakeData(idMistake, getQuestion(idQuestion, reversed), getMixUpQuestions(idMixUpQuestionsStr, reversed), wrongAnswer, count);
    }


    @NonNull
    private String formatMixUpQuestionsID(@NonNull List<Question> mixUpQuestions) {
        StringBuilder idMixUpQuestions = new StringBuilder();
        for (int i = 0; i < mixUpQuestions.size(); i++) {
            idMixUpQuestions.append(mixUpQuestions.get(i).getIDQuestion());
            if (i > 0 && i < mixUpQuestions.size() - 1) {
                idMixUpQuestions.append(",");
            }
        }
        return idMixUpQuestions.toString();
    }

    public void updateCount(@NonNull MistakeData mistakeData) {
        sqlite.execSQL("UPDATE mistakes SET count = " + mistakeData.getCount() + " WHERE idMistake = " + mistakeData.getID());
    }

    public void removeMistake(@NonNull MistakeData mistakeData) {
        sqlite.execSQL("DELETE FROM mistakes WHERE idMistake = " + mistakeData.getID());
    }

    public List<MistakeData> getMistakes() {
        String query = "SELECT * FROM mistakes";
        Cursor cursor = sqlite.rawQuery(query, null);
        List<MistakeData> mistakes = new ArrayList<>();
        while(cursor.moveToNext()) {
            int idMistake = cursor.getInt(cursor.getColumnIndexOrThrow("idMistake"));
            int idQuestion = cursor.getInt(cursor.getColumnIndexOrThrow("idQuestion"));
            String idMixUpQuestionsStr = cursor.getString(cursor.getColumnIndexOrThrow("idMixUpQuestions"));
            String wrongAnswer = cursor.getString(cursor.getColumnIndexOrThrow("wrongAnswer"));
            int count = cursor.getInt(cursor.getColumnIndexOrThrow("count"));
            boolean reversed = cursor.getInt(cursor.getColumnIndexOrThrow("reversed")) == 1;
            mistakes.add(new MistakeData(idMistake, getQuestion(idQuestion, reversed), getMixUpQuestions(idMixUpQuestionsStr, reversed), wrongAnswer, count));
        }
        cursor.close();
        return mistakes;
    }

    private List<Question> getMixUpQuestions(String idMixUpQuestionsStr, boolean reversed) {
        if (idMixUpQuestionsStr == null) {
            return null;
        }
        List<Question> questions = new ArrayList<>();
        String[] idMixUpQuestions = idMixUpQuestionsStr.split(",");
        for (String idMixUpQuestion : idMixUpQuestions) {
            questions.add(getQuestion(Integer.parseInt(idMixUpQuestion), reversed));
        }
        return questions;
    }

    public Question getQuestion(int idQuestion, boolean reversed) {
        String query = "SELECT * FROM questions WHERE idQuestion = " + idQuestion;
        Cursor cursor = sqlite.rawQuery(query, null);
        cursor.moveToNext();
        return craftQuestion(cursor, reversed);
    }

    public List<Question> generateNewQuiz(List<CharType> types, Integer numberOfQuestions) {
        String query = "SELECT * FROM questions WHERE idCharType IN (" + buildCharTypeQuery(types) + ") ORDER BY RANDOM() ";
        if (numberOfQuestions != null) {
            query += " LIMIT " + numberOfQuestions;
        }
        Cursor cursor = sqlite.rawQuery(query, null);
        List<Question> questions = new ArrayList<>();
        while(cursor.moveToNext())
        {
            questions.add(craftQuestion(cursor, new Random().nextBoolean()));
        }
        cursor.close();
        return questions;
    }

    @NonNull
    private String buildCharTypeQuery(@NonNull List<CharType> types) {
        StringBuilder query = new StringBuilder();
        for (int i = 0; i < types.size(); i++) {
            query.append(types.get(i).getID());
            if (i > 0 && i < types.size() - 1) {
                query.append(" OR ");
            }
        }
        return query.toString();
    }

    public String getQuestionsIDFrom(String wrongAnswer, boolean reversed) {
        String query = "SELECT idQuestion FROM questions WHERE " + (reversed ? "character" : "romaji") + " = ?";

        Cursor cursor = sqlite.rawQuery(query, new String[]{ wrongAnswer });
        StringBuilder idQuestions = new StringBuilder();
        while(cursor.moveToNext())
        {
            idQuestions.append(cursor.getInt(cursor.getColumnIndexOrThrow("idQuestion")));
            if (cursor.moveToNext()) {
                idQuestions.append(",");
            }
        }
        cursor.close();
        return idQuestions.length() == 0 ? null : idQuestions.toString();
    }

    public List<Question> getQuestionsFrom(String wrongAnswer, boolean reversed) {
        String query = "SELECT * FROM questions WHERE " + (reversed ? "character" : "romaji") + " = ?";

        Cursor cursor = sqlite.rawQuery(query, new String[]{ wrongAnswer });
        List<Question> questions = new ArrayList<>();
        while(cursor.moveToNext())
        {
            questions.add(craftQuestion(cursor, reversed));
        }
        cursor.close();
        return questions;
    }

    @NonNull
    private Question craftQuestion(@NonNull Cursor cursor, boolean reversed) {
        int idQuestion = cursor.getInt(cursor.getColumnIndexOrThrow("idQuestion"));
        int idCharType = cursor.getInt(cursor.getColumnIndexOrThrow("idCharType"));
        String character = cursor.getString(cursor.getColumnIndexOrThrow("character"));
        String romaji = cursor.getString(cursor.getColumnIndexOrThrow("romaji"));
        String explanation = cursor.getString(cursor.getColumnIndexOrThrow("explanation"));
        return new Question(idQuestion,idCharType, character, romaji, explanation, reversed);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
