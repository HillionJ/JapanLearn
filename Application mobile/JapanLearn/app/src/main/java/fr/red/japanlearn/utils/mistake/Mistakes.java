package fr.red.japanlearn.utils.mistake;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.red.japanlearn.database.DataBase;
import fr.red.japanlearn.utils.Question;

public class Mistakes {

    private static Mistakes instance;

    public static Mistakes getMistakes() {
        if (instance == null)
            instance = new Mistakes();
        return instance;
    }

    private final DataBase dataBase;
    private final List<MistakeData> mistakes;

    private Mistakes() {
        dataBase = DataBase.getDataBase();
        mistakes = dataBase.getMistakes();
    }

    public void addCount(Question question, String wrongAnswer) {
        MistakeData data = getMistakeFrom(question, wrongAnswer);
        if (data == null) {
            mistakes.add(dataBase.addMistake(question, wrongAnswer));
        } else {
            data.addMistake();
            dataBase.updateCount(data);
        }
    }

    public void removeCount(Question question) {
        MistakeData data = getMistakeFrom(question);
        if (data == null) {
            return;
        }
        data.removeMistake();
        if (data.getCount() == 0) {
            dataBase.removeMistake(data);
            mistakes.remove(data);
        } else {
            dataBase.updateCount(data);
        }
    }

    @Nullable
    private MistakeData getMistakeFrom(Question question, String wrongAnswer) {
        for (MistakeData data : mistakes) {
            if (data.getQuestion().isReversed() == question.isReversed()
                    && data.getQuestion().getIDQuestion() == question.getIDQuestion()
                    && data.getWrongAnswer().equals(wrongAnswer)) {
                return data;
            }
        }
        return null;
    }

    @Nullable
    private MistakeData getMistakeFrom(Question question) {
        for (MistakeData data : mistakes) {
            if (data.getQuestion().isReversed() == question.isReversed()
                    && data.getQuestion().getIDQuestion() == question.getIDQuestion()) {
                return data;
            }
        }
        return null;
    }

    public List<Question> getMistakesQuiz() {
        List<Question> questions = new ArrayList<>();
        for (MistakeData data : mistakes) {
            questions.add(data.getQuestion());
        }
        Collections.shuffle(questions);
        return questions;
    }

    public List<MistakeData> getMistakesData() {
        return mistakes;
    }

    public boolean isMistake(Question question) {
        return getMistakeFrom(question) != null;
    }
}
