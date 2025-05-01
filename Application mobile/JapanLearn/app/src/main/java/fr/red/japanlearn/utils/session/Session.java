package fr.red.japanlearn.utils.session;

import android.content.Intent;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import fr.red.japanlearn.activity.TrainActivity;
import fr.red.japanlearn.utils.IHM;
import fr.red.japanlearn.utils.Question;
import fr.red.japanlearn.utils.SessionState;
import fr.red.japanlearn.utils.chars.Hiraganas;
import fr.red.japanlearn.utils.chars.Kanji;
import fr.red.japanlearn.utils.chars.Katakanas;
import fr.red.japanlearn.utils.Settings;
import fr.red.japanlearn.utils.mistake.Mistakes;

public class Session {

    private static Session currentSession;

    public static Session getCurrentSession() {
        return currentSession;
    }

    public static void newSession() {
        Settings settings = Settings.getSettings();
        IHM ihm = IHM.getIHM();
        List<Question> questions = new ArrayList<>();

        Hiraganas.addHiraganas(questions, settings.isHiragana(), settings.isHiraganaCombined());
        Katakanas.addKatakanas(questions, settings.isKatakana(), settings.isKatakanaCombined());
        Kanji.addKanji(questions, settings.isKanji());

        if (questions.isEmpty()) {
            Toast.makeText(ihm.getActiviteActive(), "Sélection vide (Voir Paramètres)", Toast.LENGTH_SHORT).show();
            return;
        }
        Collections.shuffle(questions);
        if (settings.isNumberOfQuestionsSet()) {
            int maxNumberOfQuestions = Math.min(settings.getNumberOfQuestions(), questions.size());
            questions = questions.subList(0, maxNumberOfQuestions);
        }

        newSession(questions, SessionType.NORMAL);
    }

    public static void newSession(List<Question> questions, SessionType type) {
        currentSession = new Session(questions, type);
    }

    private final List<Question> dynamicQuestions = new ArrayList<>();
    private final List<Question> questions;
    private Question question = null;
    private SessionState sessionState;
    private final int maxNumberOfQuestions;
    private final Mistakes mistakes;
    private final SessionType type;

    public Session(List<Question> questions, SessionType type) {
        questions.forEach(Question::reset);
        this.questions = questions;
        this.dynamicQuestions.addAll(questions);
        this.maxNumberOfQuestions = questions.size();
        this.type = type;

        mistakes = Mistakes.getMistakes();

        nextTry();
        Intent intent = new Intent(IHM.getIHM().getActiviteActive(), TrainActivity.class);
        IHM.getIHM().getActiviteActive().startActivity(intent);
    }


    public void nextTry() {
        sessionState = SessionState.TRAINING;
        question = dynamicQuestions.get(0);
        if (!question.isCorrection() && type == SessionType.NORMAL) {
            question.setReversed(new Random().nextBoolean());
        }
    }

    public void setCorrect(Question question) {
        question.correct();
        dynamicQuestions.remove(question);
        if (type == SessionType.CORRECTION) {
            mistakes.remove(question);
        }
    }

    public void setIncorrect(Question question, String wrongAnswer) {
        question.requiredCorrection();
        dynamicQuestions.remove(question);
        dynamicQuestions.add(dynamicQuestions.size(), question);
        mistakes.addMistake(question, wrongAnswer);
    }

    public boolean hasNextTry() {
        return !dynamicQuestions.isEmpty();
    }

    public Question getCurrentGuessAnswerData() {
        return question;
    }

    public SessionState getSessionState() {
        return sessionState;
    }

    public void setSessionState(SessionState sessionState) {
        this.sessionState = sessionState;
    }

    public int getMaxNumberOfQuestions() {
        return maxNumberOfQuestions;
    }

    public List<Question> getDynamicQuestions() {
        return dynamicQuestions;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
