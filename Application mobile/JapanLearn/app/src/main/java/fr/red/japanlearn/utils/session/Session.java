package fr.red.japanlearn.utils.session;

import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import fr.red.japanlearn.activity.train.TrainActivity;
import fr.red.japanlearn.activity.train.list.SelectTrainActivity;
import fr.red.japanlearn.activity.train.list.CharacterTrainActivity;
import fr.red.japanlearn.database.DataBase;
import fr.red.japanlearn.utils.IHM;
import fr.red.japanlearn.utils.Learning;
import fr.red.japanlearn.utils.question.Question;
import fr.red.japanlearn.utils.SessionState;
import fr.red.japanlearn.utils.Settings;
import fr.red.japanlearn.utils.mistake.Mistakes;

public class Session {

    private static Session currentSession;

    public static Session getCurrentSession() {
        return currentSession;
    }

    public static void newSession(SessionType type) {
        Settings settings = Settings.getSettings();
        DataBase dataBase = DataBase.getDataBase();
        IHM ihm = IHM.getIHM();

        if (settings.getCharTypes().isEmpty()) {
            Toast.makeText(ihm.getActiviteActive(), "Sélection vide (Voir Paramètres)", Toast.LENGTH_SHORT).show();
            return;
        }
        List<Question> questions = dataBase.generateNewQuiz(settings.getCharTypes(), settings.isNumberOfQuestionsSet() ? settings.getNumberOfQuestions() : null);

        newSession(questions, type);
    }

    public static void newSession(List<Question> questions, SessionType type) {
        for (Question q : questions) {
            q.reset();
        }
        currentSession = new Session(questions, type);
    }

    private final List<Question> dynamicQuestions = new ArrayList<>();
    private final List<Question> questions;
    private Question question = null;
    private SessionState sessionState;
    private final int maxNumberOfQuestions;
    private final Mistakes mistakes;
    private final Learning learning;
    private final SessionType type;

    public Session(@NonNull List<Question> questions, SessionType type) {
        this.questions = questions;
        this.dynamicQuestions.addAll(questions);
        this.maxNumberOfQuestions = questions.size();
        this.type = type;

        mistakes = Mistakes.getMistakes();
        learning = Learning.getLearning();

        nextTry();
        Intent intent = new Intent(IHM.getIHM().getActiviteActive(), getNextClassType());
        IHM.getIHM().getActiviteActive().startActivity(intent);
    }

    public Class<? extends TrainActivity> getNextClassType() {
        if (getCurrentGuessAnswerData().getIDCharType() == 4) {
            return SelectTrainActivity.class;
        }
        return CharacterTrainActivity.class;
    }


    public void nextTry() {
        sessionState = SessionState.TRAINING;
        question = dynamicQuestions.get(0);
    }

    public void setCorrect(@NonNull Question question) {
        question.correct();
        dynamicQuestions.remove(question);
        if (type == SessionType.CORRECTION) {
            mistakes.removeCount(question);
        } else if (type == SessionType.LEARNING) {
            learning.updateScore(question, 1);
        }
    }

    public void setIncorrect(@NonNull Question question, String wrongAnswer) {
        question.requiredCorrection();
        dynamicQuestions.remove(question);
        dynamicQuestions.add(dynamicQuestions.size(), question);
        if (type != SessionType.CORRECTION) {
            mistakes.addCount(question, wrongAnswer);
            learning.updateScore(question, -1);
        }
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
