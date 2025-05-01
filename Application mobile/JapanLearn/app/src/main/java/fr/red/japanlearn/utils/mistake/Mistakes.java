package fr.red.japanlearn.utils.mistake;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.red.japanlearn.utils.Question;

public class Mistakes {

    private static Mistakes instance;

    public static Mistakes getMistakes() {
        if (instance == null)
            instance = new Mistakes();
        return instance;
    }

    private final List<MistakeData> mistakes = new ArrayList<>();

    public void addMistake(Question question, String wrongAnswer) {
        MistakeData mistakeData = null;
        for (MistakeData data : mistakes) {
            if (data.getQuestion().isReversed() == question.isReversed() && data.getQuestion().getGuess().equals(question.getGuess()) && data.getWrongAnswer().equals(wrongAnswer)) {
                mistakeData = data;
                break;
            }
        }
        if (mistakeData == null) {
            mistakeData = new MistakeData(question, wrongAnswer);
            mistakes.add(mistakeData);
        }
        mistakeData.addMistake();
    }

    public void remove(Question question) {
        for (MistakeData data : mistakes) {
            if (data.getQuestion().isReversed() == question.isReversed() && data.getQuestion().getGuess().equals(question.getGuess())) {
                data.removeMistake();
                break;
            }
        }
    }

    public boolean isMistake(Question question) {
        for (MistakeData data : mistakes) {
            if (data.getQuestion().isReversed() == question.isReversed() && data.getQuestion().getGuess().equals(question.getGuess())) {
                return true;
            }
        }
        return false;
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
}
