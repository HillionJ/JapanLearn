package fr.red.japanlearn.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import fr.red.japanlearn.R;
import fr.red.japanlearn.utils.IHM;
import fr.red.japanlearn.utils.storage.Settings;
import fr.red.japanlearn.utils.Question;
import fr.red.japanlearn.utils.chars.Hiraganas;
import fr.red.japanlearn.utils.chars.Kanji;
import fr.red.japanlearn.utils.chars.Katakanas;
import fr.red.japanlearn.utils.SessionState;
import fr.red.japanlearn.utils.storage.mistake.Mistakes;

public class MainActivity extends AppCompatActivity {

    private static MainActivity instance;

    public static MainActivity getInstance() {
        return instance;
    }

    private Settings settings;
    private List<Question> dynamicQuestions = new ArrayList<>();
    private final List<Question> questions = new ArrayList<>();
    private Question question = null;
    private SessionState sessionState;
    private int maxNumberOfQuestions;
    private Mistakes mistakes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;

        initLayout();
        iniVars();
    }


    public void nextTry() {
        sessionState = SessionState.TRAINING;
        question = dynamicQuestions.get(0);
        if (!question.isCorrection()){
            question.setReversed(new Random().nextBoolean());
        }
    }

    public void setCorrect(Question question) {
        question.correct();
        dynamicQuestions.remove(question);
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

    private void iniVars() {
        IHM ihm = IHM.init(this);
        ihm.ajouterIHM(this);

        settings = Settings.getSettings();
        mistakes = Mistakes.getMistakes();

        initStartButton();
        initSettingsButton();
        initMistakesButton();
    }

    private void initLayout() {
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void initMistakesButton() {
        Button mistakesButton = findViewById(R.id.mistakesReview);
        mistakesButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MistakeActivity.class);
            startActivity(intent);
        });
    }

    public void initSettingsButton() {
        Button settingsButton = findViewById(R.id.settings);
        settingsButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        });
    }

    private void initStartButton() {
        Button startButton = findViewById(R.id.start);
        startButton.setOnClickListener(view -> {
            dynamicQuestions.clear();
            Hiraganas.addHiraganas(dynamicQuestions, settings.isHiragana(), settings.isHiraganaCombined());
            Katakanas.addKatakanas(dynamicQuestions, settings.isKatakana(), settings.isKatakanaCombined());
            Kanji.addKanji(dynamicQuestions, settings.isKanji());

            if (dynamicQuestions.isEmpty()) {
                Toast.makeText(MainActivity.this, "Sélection vide (Voir Paramètres)", Toast.LENGTH_SHORT).show();
                return;
            }
            Collections.shuffle(dynamicQuestions);
            if (settings.isNumberOfQuestionsSet()) {
                maxNumberOfQuestions = Math.min(settings.getNumberOfQuestions(), dynamicQuestions.size());
                dynamicQuestions = dynamicQuestions.subList(0, maxNumberOfQuestions);
            } else {
                maxNumberOfQuestions = dynamicQuestions.size();
            }
            dynamicQuestions.forEach(Question::reset);

            questions.clear();
            questions.addAll(dynamicQuestions);

            nextTry();
            Intent intent = new Intent(MainActivity.this, TrainActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        sessionState = SessionState.HOME;
    }

    @Override
    protected void onResume() {
        super.onResume();
        sessionState = SessionState.HOME;
    }
}