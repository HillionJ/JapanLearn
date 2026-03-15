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
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import fr.red.japanlearn.utils.question.Question;
import fr.red.japanlearn.utils.mistake.MistakeData;
import fr.red.japanlearn.utils.question.list.SelectQuestion;
import fr.red.japanlearn.utils.question.list.TextQuestion;
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
        List<Question> questions = getAllDatabaseQuestions(Collections.singletonList(CharType.fromID(question.getIDCharType())));

        String reversedFlag = question.isReversed() ? "1" : "0";
        String idMixUp = null; //TODO Retirer/Changer le mixup

        String query = "INSERT INTO mistakes (idQuestion, idMixUpQuestions, wrongAnswer, reversed) VALUES (" + question.getIDQuestion() + ", ?, ?, " + reversedFlag + ")";
        sqlite.execSQL(query, new Object[]{ idMixUp, wrongAnswer });

        Cursor cursor = sqlite.rawQuery("SELECT * FROM mistakes ORDER BY idMistake DESC LIMIT 1", null);
        cursor.moveToNext();
        int idMistake = cursor.getInt(cursor.getColumnIndexOrThrow("idMistake"));
        int idQuestion = cursor.getInt(cursor.getColumnIndexOrThrow("idQuestion"));
        String idMixUpQuestionsStr = null; //TODO Retirer/Changer le mixup
        int count = cursor.getInt(cursor.getColumnIndexOrThrow("count"));
        boolean reversed = cursor.getInt(cursor.getColumnIndexOrThrow("reversed")) == 1;
        cursor.close();

        Question q = getQuestion(idQuestion, reversed);
        q.updateSimilarity(questions);

        return new MistakeData(idMistake, q, null, wrongAnswer, count);
    }

    public void updateCount(@NonNull MistakeData mistakeData) {
        sqlite.execSQL("UPDATE mistakes SET count = " + mistakeData.getCount() + " WHERE idMistake = " + mistakeData.getID());
    }

    public void removeMistake(@NonNull MistakeData mistakeData) {
        sqlite.execSQL("DELETE FROM mistakes WHERE idMistake = " + mistakeData.getID());
    }

    public List<MistakeData> getMistakes() {
        List<Question> questions = getAllDatabaseQuestions(Arrays.asList(CharType.values));

        String query = "SELECT * FROM mistakes";
        Cursor cursor = sqlite.rawQuery(query, null);
        List<MistakeData> mistakes = new ArrayList<>();
        while(cursor.moveToNext()) {
            int idMistake = cursor.getInt(cursor.getColumnIndexOrThrow("idMistake"));
            int idQuestion = cursor.getInt(cursor.getColumnIndexOrThrow("idQuestion"));
            String idMixUpQuestionsStr = null; //TODO Retirer/Changer le mixup
            String wrongAnswer = cursor.getString(cursor.getColumnIndexOrThrow("wrongAnswer"));
            int count = cursor.getInt(cursor.getColumnIndexOrThrow("count"));
            boolean reversed = cursor.getInt(cursor.getColumnIndexOrThrow("reversed")) == 1;
            Question question = getQuestion(idQuestion, reversed);
            question.updateSimilarity(questions);
            mistakes.add(new MistakeData(idMistake, question, null /*TODO Retirer/Changer le mixup*/, wrongAnswer, count));
        }
        cursor.close();
        return mistakes;
    }

    public Question getQuestion(int idQuestion, boolean reversed) {
        String query = "SELECT * FROM questions WHERE idQuestion = " + idQuestion;
        Cursor cursor = sqlite.rawQuery(query, null);
        cursor.moveToNext();
        return craftQuestion(cursor, reversed);
    }

    private List<Question> getAllDatabaseQuestions(List<CharType> types) {
        String query = "SELECT * FROM questions WHERE idCharType IN (" + listJoinCharType(types, ",") + ")";
        Cursor cursor = sqlite.rawQuery(query, null);
        List<Question> questions = new ArrayList<>();
        while(cursor.moveToNext())
        {
            questions.add(craftQuestion(cursor, new Random().nextBoolean()));
        }
        cursor.close();
        return questions;
    }

    public List<Question> generateNewQuiz(List<CharType> types, Integer numberOfQuestions) {
        List<Question> questions = getAllDatabaseQuestions(types);

        List<Question> limitedQuiz = new ArrayList<>();
        if (numberOfQuestions == null) {
            limitedQuiz.addAll(questions);
            Collections.shuffle(limitedQuiz);
        } else {
            int n = types.size();
            int countPerCategory = (numberOfQuestions + n - 1) / n;

            for (CharType ct : types) {
                List<Question> charQuestion = new ArrayList<>();
                for (Question question : questions) {
                    if (question.getIDCharType() == ct.getID()) {
                        charQuestion.add(question);
                    }
                }
                Collections.shuffle(charQuestion);
                charQuestion = charQuestion.subList(0, countPerCategory);
                limitedQuiz.addAll(charQuestion);
            }
            Collections.shuffle(limitedQuiz);
            limitedQuiz = limitedQuiz.subList(0, numberOfQuestions);
        }

        for (Question question : limitedQuiz) {
            question.updateSimilarity(questions);
        }

        return limitedQuiz;
    }

    @NonNull
    public static String listJoin(@NonNull List<String> list, String joinStr) {
        StringBuilder query = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            query.append(list.get(i));
            if (i < list.size() - 1) query.append(joinStr);
        }
        return query.toString();
    }

    @NonNull
    public static String listJoinCharType(@NonNull List<CharType> list, String joinStr) {
        StringBuilder query = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            query.append(list.get(i).getID());
            if (i < list.size() - 1) query.append(joinStr);
        }
        return query.toString();
    }

    @NonNull
    private Question craftQuestion(@NonNull Cursor cursor, boolean reversed) {
        int idQuestion = cursor.getInt(cursor.getColumnIndexOrThrow("idQuestion"));
        int idCharType = cursor.getInt(cursor.getColumnIndexOrThrow("idCharType"));
        String character = cursor.getString(cursor.getColumnIndexOrThrow("character"));
        String romaji = cursor.getString(cursor.getColumnIndexOrThrow("romaji"));
        String explanation = cursor.getString(cursor.getColumnIndexOrThrow("explanation"));
        if (CharType.fromID(idCharType) == CharType.VOCABULARY) {
            return new SelectQuestion(idQuestion,idCharType, character, romaji, explanation, reversed);
        }
        return new TextQuestion(idQuestion,idCharType, character, romaji, explanation, reversed);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
