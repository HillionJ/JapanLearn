package fr.red.japanlearn.utils.storage.mistake;

import java.util.List;

import fr.red.japanlearn.utils.Question;

public class MistakeData {

    private int mistakeCount = 0;
    private final Question question;
    private final String wrongAnswer;
    private final MistakeType type;
    private final List<Question> mixUpQuestion;

    public MistakeData(Question question, String wrongAnswer) {
        this.question = question.clone();
        this.wrongAnswer = wrongAnswer;
        this.mixUpQuestion = question.getOrigin().getMixUpQuestions(wrongAnswer, question.isReversed());
        this.type = mixUpQuestion.isEmpty() ? MistakeType.UNKOWN_ANSWER : MistakeType.MIX_UP;
    }

    public boolean isFrequent() {
        return mistakeCount >= 3;
    }

    public boolean isReverseMode() {
        return question.isReversed();
    }

    public void addMistake() {
        mistakeCount++;
    }

    public void removeMistake() {
        mistakeCount--;
        if (mistakeCount <= 0) {
            Mistakes.getMistakes().remove(this);
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
