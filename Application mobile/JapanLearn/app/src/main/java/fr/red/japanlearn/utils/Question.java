package fr.red.japanlearn.utils;

public class Question {

    private final int idQuestion;
    private final int idCharType;
    private final String character;
    private final String romaji;
    private final String explanation;
    private final boolean reversed;

    private boolean correction = false;
    private boolean correct = false;
    private boolean wasIncorrect = false;

    public Question(int idQuestion, int idCharType, String character, String romaji, String explanation, boolean reversed) {
        this.idQuestion = idQuestion;
        this.idCharType = idCharType;
        this.character = character;
        this.romaji = romaji;
        this.explanation = explanation;
        this.reversed = reversed;
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
}
