package fr.red.japanlearn.utils.guess;

public class GuessAnswerData {

    private String guess;
    private String answer;
    private String explanation;
    private boolean correction = false;
    private boolean correct = false;
    private boolean wasIncorrect = false;
    private boolean reversed;

    public GuessAnswerData(String guess, String answer) {
        this(guess, answer, null);
    }

    public GuessAnswerData(String guess, String answer, String explanation) {
        this.guess = guess;
        this.answer = answer;
        this.explanation = explanation;
    }

    public boolean hasExplanation() {
        return explanation != null;
    }

    public String getGuess() {
        return reversed ? answer : guess;
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
}
