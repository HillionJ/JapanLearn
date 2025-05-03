package fr.red.japanlearn.utils.session;

import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import fr.red.japanlearn.activity.TrainActivity;
import fr.red.japanlearn.database.DataBase;
import fr.red.japanlearn.utils.IHM;
import fr.red.japanlearn.utils.Question;
import fr.red.japanlearn.utils.SessionState;
import fr.red.japanlearn.utils.Settings;
import fr.red.japanlearn.utils.mistake.Mistakes;

public class Session {

    private static Session currentSession;

    public static Session getCurrentSession() {
        return currentSession;
    }

    public static void newSession() {
        Settings settings = Settings.getSettings();
        DataBase dataBase = DataBase.getDataBase();
        IHM ihm = IHM.getIHM();

        if (settings.getCharTypes().isEmpty()) {
            Toast.makeText(ihm.getActiviteActive(), "Sélection vide (Voir Paramètres)", Toast.LENGTH_SHORT).show();
            return;
        }
        List<Question> questions = dataBase.generateNewQuiz(settings.getCharTypes(), settings.isNumberOfQuestionsSet() ? settings.getNumberOfQuestions() : null);

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

    public Session(@NonNull List<Question> questions, SessionType type) {
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
    }

    public void setCorrect(@NonNull Question question) {
        question.correct();
        dynamicQuestions.remove(question);
        if (type == SessionType.CORRECTION) {
            mistakes.removeCount(question);
        }
    }

    public void setIncorrect(@NonNull Question question, String wrongAnswer) {
        question.requiredCorrection();
        dynamicQuestions.remove(question);
        dynamicQuestions.add(dynamicQuestions.size(), question);
        mistakes.addCount(question, wrongAnswer);
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
