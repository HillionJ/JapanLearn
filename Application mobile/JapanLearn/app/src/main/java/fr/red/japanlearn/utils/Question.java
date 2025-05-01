package fr.red.japanlearn.utils;

import androidx.annotation.NonNull;

import fr.red.japanlearn.utils.chars.CharOrigin;

public class Question {

    private final CharOrigin charOrigin;
    private final String guess;
    private final String answer;
    private final String explanation;
    private boolean correction = false;
    private boolean correct = false;
    private boolean wasIncorrect = false;
    private boolean reversed;

    public Question(CharOrigin charOrigin, String guess, String answer) {
        this(charOrigin, guess, answer, null);
    }

    public Question(CharOrigin charOrigin, String guess, String answer, String explanation) {
        this.charOrigin = charOrigin;
        this.guess = guess;
        this.answer = answer;
        this.explanation = explanation;
    }

    private Question(@NonNull Question question) {
        this.charOrigin = question.charOrigin;
        this.guess = question.guess;
        this.answer = question.answer;
        this.explanation = question.explanation;
        this.correction = question.correction;
        this.correct = question.correct;
        this.wasIncorrect = question.wasIncorrect;
        this.reversed = question.reversed;
    }

    @NonNull
    public Question clone() {
        return new Question(this);
    }

    public boolean hasExplanation() {
        return explanation != null;
    }

    public String getGuess(boolean reversed) {
        return reversed ? answer : guess;
    }

    public String getGuess() {
        return reversed ? answer : guess;
    }

    public String getAnswer(boolean reversed) {
        return reversed ? guess : answer;
    }

    public String getAnswer() {
        return reversed ? guess : answer;
    }

    public String getExplanation() {
        return explanation;
    }

    public void requiredCorrection() {
        this.correction = true;
        this.wasIncorrect = true;
    }

    public boolean isCorrection() {
        return correction;
    }

    public void setReversed(boolean reversed) {
        this.reversed = reversed;
    }

    public boolean isReversed() {
        return reversed;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void correct() {
        this.correct = true;
    }

    public boolean wasIncorrect() {
        return wasIncorrect;
    }

    public void reset() {
        this.correction = false;
        this.correct = false;
        this.wasIncorrect = false;
    }

    public CharOrigin getOrigin() {
        return charOrigin;
    }
}
