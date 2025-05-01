package fr.red.japanlearn.activity;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;
import java.util.Map;

import fr.red.japanlearn.R;
import fr.red.japanlearn.utils.IHM;
import fr.red.japanlearn.utils.storage.Settings;

public class SettingsActivity extends AppCompatActivity {

    private Settings settings;
    private CheckBox hiraganaCheckBox, katakanaCheckBox, kanjiCheckBox, hiraganaCombinedCheckBox, katakanaCombinedCheckBox;
    private EditText numberOfQuestions;
    private final Map<String, Object> settingsMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLayout();
        initVars();

        restoreSettings();
    }

    public void restoreSettings() {
        hiraganaCheckBox.setChecked(settings.isHiragana());
        hiraganaCombinedCheckBox.setChecked(settings.isHiraganaCombined());
        katakanaCheckBox.setChecked(settings.isKatakana());
        katakanaCombinedCheckBox.setChecked(settings.isKatakanaCombined());
        kanjiCheckBox.setChecked(settings.isKanji());
        numberOfQuestions.setText(settings.numberOfQuestionsStr());
    }

    private void initVars() {
        IHM ihm = IHM.getIHM();
        ihm.ajouterIHM(this);
        settings = Settings.getSettings();

        hiraganaCheckBox = findViewById(R.id.hiraganaCheckBox);
        katakanaCheckBox = findViewById(R.id.katakanaCheckBox);
        kanjiCheckBox = findViewById(R.id.kanjiCheckBox);

        hiraganaCombinedCheckBox = findViewById(R.id.hiraganaCombinedCheckBox);
        katakanaCombinedCheckBox = findViewById(R.id.katakanaCombinedCheckBox);

        initMaxQuestionNumberInput();
        initApplyButton();
        initCloseButton();

        settingsMap.put("hiraganaCheckBox", hiraganaCheckBox);
        settingsMap.put("hiraganaCombinedCheckBox", hiraganaCombinedCheckBox);
        settingsMap.put("katakanaCheckBox", katakanaCheckBox);
        settingsMap.put("katakanaCombinedCheckBox", katakanaCombinedCheckBox);
        settingsMap.put("kanjiCheckBox", kanjiCheckBox);
        settingsMap.put("numberOfQuestions", numberOfQuestions);
    }

    private void initLayout() {
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initCloseButton() {
        ImageView close = findViewById(R.id.close);
        close.setOnClickListener(view -> finish());
    }

    public void initApplyButton() {
        Button applySettings = findViewById(R.id.apply_settings);
        applySettings.setOnClickListener(view -> {
            settings.saveSettings(settingsMap);
            finish();
        });
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
}