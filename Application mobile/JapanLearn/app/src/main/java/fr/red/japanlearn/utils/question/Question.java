package fr.red.japanlearn.utils.question;

import java.util.ArrayList;
import java.util.List;

public abstract class Question {

    protected final int idQuestion;
    protected final int idCharType;
    protected final String character;
    protected final String romaji;
    protected final String explanation;
    protected final boolean reversed;
    protected final List<String> possibleAnswers = new ArrayList<>();
    protected final int score;

    protected boolean correction = false;
    protected boolean correct = false;
    protected boolean wasIncorrect = false;

    public Question(int idQuestion, int idCharType, String character, String romaji, String explanation, boolean reversed, int score) {
        this.idQuestion = idQuestion;
        this.idCharType = idCharType;
        this.character = character;
        this.romaji = romaji;
        this.explanation = explanation;
        this.reversed = reversed;
        this.score = score;
    }

    public int getIDQuestion() {
        return idQuestion;
    }

    public int getIDCharType() {
        return idCharType;
    }

    public boolean hasExplanation() {
        return explanation != null;
    }

    public String getQuestion(boolean reversed) {
        return reversed ? romaji : character;
    }

    public String getQuestion() {
        return reversed ? romaji : character;
    }

    public String getAnswer(boolean reversed) {
        return reversed ? character : romaji;
    }

    public String getAnswer() {
        return reversed ? character : romaji;
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

    public abstract boolean isValidAnswer(String answer);

    public abstract void updateSimilarity(List<Question> allQuestions);

    protected boolean isSameObject(Question q) {
        return getQuestion(false).equals(q.getQuestion(false))
                && getAnswer(false).equals(q.getAnswer(false));
    }

    public List<String> getPossibleAnswers() {
        return possibleAnswers;
    }

    public String getInfoTitle() {
        return "Signification : ";
    }

    public void reset() {
        correction = false;
        correct = false;
        wasIncorrect = false;
    }

    public int getScore() {
        return this.score;
    }
}
