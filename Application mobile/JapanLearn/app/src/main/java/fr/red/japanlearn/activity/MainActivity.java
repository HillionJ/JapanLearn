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
import fr.red.japanlearn.utils.Settings;
import fr.red.japanlearn.utils.guess.GuessAnswerData;
import fr.red.japanlearn.utils.chars.Hiraganas;
import fr.red.japanlearn.utils.chars.Kanji;
import fr.red.japanlearn.utils.chars.Katakanas;
import fr.red.japanlearn.utils.session.SessionState;

public class MainActivity extends AppCompatActivity {

    private static MainActivity instance;

    public static MainActivity getInstance() {
        return instance;
    }

    private Settings settings;
    private List<GuessAnswerData> currentSession = new ArrayList<>();
    private GuessAnswerData guessAnswerData = null;
    private SessionState sessionState;
    private int maxNumberOfQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;

        initLayout();
        iniVars();
    }


    public void nextTry() {
        sessionState = SessionState.TRAINING;
        guessAnswerData = currentSession.get(new Random().nextInt(currentSession.size()));
        if (!guessAnswerData.isCorrection()){
            guessAnswerData.setReversed(new Random().nextBoolean());
        }
    }

    public boolean hasNextTry() {
        return !currentSession.isEmpty();
    }

    public void removeGuessAnswerData(GuessAnswerData guessAnswerData) {
        currentSession.remove(guessAnswerData);
    }

    public GuessAnswerData getCurrentGuessAnswerData() {
        return guessAnswerData;
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

    public List<GuessAnswerData> getCurrentSession() {
        return currentSession;
    }

    private void iniVars() {
        IHM ihm = IHM.init(this);
        ihm.ajouterIHM(this);
        settings = Settings.getSettings();

        initStartButton();
        initSettingsButton();
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
            currentSession.forEach(GuessAnswerData::reset);
            currentSession.clear();
            Hiraganas.addHiraganas(currentSession, settings.isHiragana(), settings.isHiraganaCombined());
            Katakanas.addKatakanas(currentSession, settings.isKatakana(), settings.isKatakanaCombined());
            Kanji.addKanji(currentSession, settings.isKanji());

            if (currentSession.isEmpty()) {
                Toast.makeText(MainActivity.this, "Sélection vide", Toast.LENGTH_SHORT).show();
                return;
            }
            if (settings.isNumberOfQuestionsSet()) {
                Collections.shuffle(currentSession);
                maxNumberOfQuestions = Math.min(settings.getNumberOfQuestions(), currentSession.size());
                currentSession = currentSession.subList(0, maxNumberOfQuestions);
            } else {
                maxNumberOfQuestions = currentSession.size();
            }

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