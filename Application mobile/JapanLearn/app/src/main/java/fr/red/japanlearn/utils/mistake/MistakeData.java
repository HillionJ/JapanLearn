package fr.red.japanlearn.utils.mistake;

import androidx.annotation.NonNull;

import java.util.List;

import fr.red.japanlearn.utils.Question;

public class MistakeData {

    private int mistakeCount = 0;
    private final Question question;
    private final String wrongAnswer;
    private final MistakeType type;
    private final List<Question> mixUpQuestion;

    public MistakeData(@NonNull Question question, String wrongAnswer) {
        this.question = question.clone();
        this.wrongAnswer = wrongAnswer;
        this.mixUpQuestion = question.getOrigin().getMixUpQuestions(wrongAnswer, question.isReversed());
        this.type = mixUpQuestion.isEmpty() ? MistakeType.UNKOWN_ANSWER : MistakeType.MIX_UP;
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
        if (mistakeCount <= 0) {
            Mistakes.getMistakes().getMistakesData().remove(this);
        }
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
