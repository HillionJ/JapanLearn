package fr.red.japanlearn.utils.mistake;

import androidx.annotation.NonNull;

import java.util.List;

import fr.red.japanlearn.utils.Question;

public class MistakeData {

    private final int idMistake;
    private final Question question;
    private final List<Question> mixUpQuestion;
    private final String wrongAnswer;
    private int mistakeCount;
    private final MistakeType type;

    public MistakeData(int idMistake, @NonNull Question question, List<Question> mixUpQuestion, String wrongAnswer, int count) {
        this.idMistake = idMistake;
        this.question = question;
        this.mixUpQuestion = mixUpQuestion;
        this.wrongAnswer = wrongAnswer;
        this.mistakeCount = count;
        this.type = mixUpQuestion == null ? MistakeType.UNKOWN_ANSWER : MistakeType.MIX_UP;
    }

    @SuppressWarnings("unused")
    //TODO Utiliser dans le future
    public boolean isFrequent() {
        return mistakeCount >= 3;
    }

    public void addMistake() {
        mistakeCount++;
    }

    public void removeMistake() {
        mistakeCount--;
    }

    public int getID() {
        return idMistake;
    }

    public Question getQuestion() {
        return question;
    }

    public String getWrongAnswer() {
        return wrongAnswer;
    }

    public int getCount() {
        return mistakeCount;
    }

    public MistakeType getType() {
        return type;
    }

    public List<Question> getMixUpQuestion() {
        return mixUpQuestion;
    }
}
