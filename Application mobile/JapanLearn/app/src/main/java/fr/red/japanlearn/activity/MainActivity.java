package fr.red.japanlearn.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import fr.red.japanlearn.R;
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

    //Saved Settings
    private CheckBox hiraganaCheckBox, katakanaCheckBox, kanjiCheckBox, hiraganaCombinedCheckBox, katakanaCombinedCheckBox;
    private EditText numberOfQuestions;

    //Local vars
    private List<GuessAnswerData> currentSession = new ArrayList<>();
    private GuessAnswerData guessAnswerData = null;
    private SessionState sessionState;
    private int maxNumberOfQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        iniVars();
        restoreSettings();
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

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        SharedPreferences prefs = getSharedPreferences("Settings", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putBoolean("hiraganaCheckBox", hiraganaCheckBox.isChecked());
        editor.putBoolean("hiraganaCombinedCheckBox", hiraganaCombinedCheckBox.isChecked());
        editor.putBoolean("katakanaCheckBox", katakanaCheckBox.isChecked());
        editor.putBoolean("katakanaCombinedCheckBox", katakanaCombinedCheckBox.isChecked());
        editor.putBoolean("kanjiCheckBox", kanjiCheckBox.isChecked());
        editor.putString("numberOfQuestions", numberOfQuestions.getText().toString());

        editor.apply();

    }

    public void restoreSettings() {
        SharedPreferences prefs = getSharedPreferences("Settings", MODE_PRIVATE);

        hiraganaCheckBox.setChecked(prefs.getBoolean("hiraganaCheckBox", false));
        hiraganaCombinedCheckBox.setChecked(prefs.getBoolean("hiraganaCombinedCheckBox", false));
        katakanaCheckBox.setChecked(prefs.getBoolean("katakanaCheckBox", false));
        katakanaCombinedCheckBox.setChecked(prefs.getBoolean("katakanaCombinedCheckBox", false));
        kanjiCheckBox.setChecked(prefs.getBoolean("kanjiCheckBox", false));
        numberOfQuestions.setText(prefs.getString("numberOfQuestions", ""));

    }

    private void initMaxQuestionNumberInput() {
        numberOfQuestions = findViewById(R.id.numberOfQuestions);
        numberOfQuestions.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_NEXT || actionId == EditorInfo.IME_ACTION_GO || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                // Fermer le clavier
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                // Enlever le focus
                v.clearFocus();

                return true;
            }
            return false;
        });
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            View rootView = findViewById(android.R.id.content);
            rootView.getViewTreeObserver().addOnGlobalLayoutListener(() -> {
                Rect r = new Rect();
                rootView.getWindowVisibleDisplayFrame(r);
                int screenHeight = rootView.getRootView().getHeight();
                int keypadHeight = screenHeight - r.bottom;

                // Clavier fermé si height < 15% de l'écran
                if (keypadHeight < screenHeight * 0.15) {
                    // Enlève le focus de l'EditText si le clavier est fermé
                    numberOfQuestions.clearFocus();
                }
            });
        }

        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        View view = this.getCurrentFocus();
        if (view != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            view.clearFocus(); // enlève le focus de l'EditText en plus
        }
    }

    private void initStartButton() {
        Button startButton = findViewById(R.id.start);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentSession.forEach(GuessAnswerData::reset);
                currentSession.clear();
                Hiraganas.addHiraganas(currentSession, hiraganaCheckBox.isChecked(), hiraganaCombinedCheckBox.isChecked());
                Katakanas.addKatakanas(currentSession, katakanaCheckBox.isChecked(), katakanaCombinedCheckBox.isChecked());
                Kanji.addKanji(currentSession, kanjiCheckBox.isChecked());

                if (currentSession.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Sélection vide", Toast.LENGTH_SHORT).show();
                    return;
                }

                String maxNumberOfQuestionsString = numberOfQuestions.getText().toString();
                int maxNumberOfQuestionsInteger;
                if (numberOfQuestions.length() > 0 && (maxNumberOfQuestionsInteger = parseInt(maxNumberOfQuestionsString)) > 0) {
                    Collections.shuffle(currentSession);
                    maxNumberOfQuestions = Math.min(maxNumberOfQuestionsInteger, currentSession.size());
                    currentSession = currentSession.subList(0, maxNumberOfQuestions);
                } else {
                    maxNumberOfQuestions = currentSession.size();
                }

                nextTry();
                Intent intent = new Intent(MainActivity.this, TrainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void iniVars() {
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.background), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        hiraganaCheckBox = findViewById(R.id.hiraganaCheckBox);
        katakanaCheckBox = findViewById(R.id.katakanaCheckBox);
        kanjiCheckBox = findViewById(R.id.kanjiCheckBox);

        hiraganaCombinedCheckBox = findViewById(R.id.hiraganaCombinedCheckBox);
        katakanaCombinedCheckBox = findViewById(R.id.katakanaCombinedCheckBox);

        initStartButton();
        initMaxQuestionNumberInput();
    }

    private int parseInt(String string) {
        int integer = 0;
        try {
            integer = Integer.parseInt(string);
        } catch (Exception ignored) {
            try {
                integer = (int)  Double.parseDouble(string);
            } catch (Exception ignored1) {
            }
        }
        return integer;
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