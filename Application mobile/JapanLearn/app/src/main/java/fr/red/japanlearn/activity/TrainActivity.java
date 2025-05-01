package fr.red.japanlearn.activity;

import static java.lang.String.*;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import fr.red.japanlearn.R;
import fr.red.japanlearn.utils.IHM;
import fr.red.japanlearn.utils.Question;
import fr.red.japanlearn.utils.SessionState;
import fr.red.japanlearn.utils.SoftKeyboardInput;
import fr.red.japanlearn.utils.storage.mistake.Mistakes;

public class TrainActivity extends AppCompatActivity {

    private String correctAnswer;
    private TextInputEditText inputText;
    private LinearLayout errorContainer;
    private TextView errorText;
    private TextView errorTitle;
    private Button validate;
    private Question question;
    private Mistakes mistakes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLayout();
        initVars();

        closeKeyBoard();
        if (MainActivity.getInstance().getSessionState() == SessionState.ENDING) {
            if (question.isCorrect() && question.hasExplanation()) {
                showInfoMessage(true);
                disableEditText();
            } else if (!question.isCorrect()) {
                showErrorMessage(true);
                disableEditText();
            }
        } else {
            updateKeyboardLang();
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                openKeyboard();
            }
        }
    }

    private void disableEditText() {
        inputText.setEnabled(false);
    }

    private void showErrorMessage(boolean instantDisplay) {
        showMessage(correctAnswer, false, instantDisplay);
    }

    private void showInfoMessage(boolean instantDisplay) {
        showMessage(question.getExplanation(), true, instantDisplay);
    }

    private void showMessage(String message, boolean goodAnswer,boolean instantDisplay) {
        if (instantDisplay) {
            displayLayout(message, goodAnswer);
            return;
        }
        Animation slideIn = AnimationUtils.loadAnimation(this, R.anim.slide_in_bottom);
        validate.setVisibility(View.INVISIBLE);

        errorContainer.postDelayed(() -> {
            displayLayout(message, goodAnswer);

            errorContainer.startAnimation(slideIn);
            validate.startAnimation(slideIn);
        }, 150);
    }

    private void displayLayout(String message, boolean goodAnswer) {
        errorContainer.setBackgroundColor(getResources().getColor(goodAnswer ? R.color.good_answer : R.color.wrong_answer));
        errorText.setText(message);
        errorTitle.setText(goodAnswer ? "Signification : " : "Bonne réponse : ");
        errorContainer.setVisibility(View.VISIBLE);
        validate.setVisibility(View.VISIBLE);
    }


    public void restartActivity() {
        if (!MainActivity.getInstance().hasNextTry()){
            finish();
            Intent intent = new Intent(this, StatsActivity.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            return;
        }
        MainActivity.getInstance().nextTry();
        finish();
        startActivity(getIntent());
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    private void openKeyboard() {
        inputText.postDelayed(() -> {
            inputText.requestFocus();
            InputMethodManager imm2 = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

            // Force vraiment l'ouverture du clavier
            if (imm2 != null) {
                imm2.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
            }
        }, 200);
    }

    private void updateKeyboardLang() {
        inputText.setImeHintLocales(new android.os.LocaleList(new java.util.Locale(!question.isReversed() ? "fr" : "ja")));
    }

    private void closeKeyBoard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(inputText.getWindowToken(), 0);
    }

    private void initLayout() {
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_train);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        new SoftKeyboardInput(this);
    }

    private void initVars() {
        IHM ihm = IHM.getIHM();
        ihm.ajouterIHM(this);

        mistakes = Mistakes.getMistakes();

        question = MainActivity.getInstance().getCurrentGuessAnswerData();
        TextView guess = findViewById(R.id.guess);
        guess.setText(question.getGuess());

        inputText = findViewById(R.id.textInput);
        inputText.setText("");
        inputText.requestFocus();

        correctAnswer = question.getAnswer();
        Log.d("_RED", "correctAnswer: " + correctAnswer);

        errorContainer = findViewById(R.id.errorContainer);
        errorText = findViewById(R.id.errorText);
        errorTitle = findViewById(R.id.errorTitle);

        TextView session_progress = findViewById(R.id.session_progress);
        int maxNumber = MainActivity.getInstance().getMaxNumberOfQuestions();
        int currentNumber = maxNumber - MainActivity.getInstance().getDynamicQuestions().size() + 1;
        session_progress.setText(format(getString(R.string.quiz_progress_format), currentNumber, maxNumber));

        TextView wrong_label = findViewById(R.id.wrong_label);
        if (question.isCorrection()) {
            wrong_label.setText(R.string.error_label);
            wrong_label.setVisibility(View.VISIBLE);
        } else if (mistakes.isMistake(question)) {
            wrong_label.setText(R.string.frequent_label);
            wrong_label.setVisibility(View.VISIBLE);
        }

        initValidationButton();

        initCloseButton();
    }

    private void initValidationButton() {

        validate = findViewById(R.id.validate);
        if (MainActivity.getInstance().getSessionState() == SessionState.ENDING) {
            validate.setText(R.string.continuer);
        }

        validate.setOnClickListener(new View.OnClickListener() {
            boolean _continue = MainActivity.getInstance().getSessionState() == SessionState.ENDING;
            @Override
            public void onClick(View view) {
                if (_continue) {
                    restartActivity();
                    return;
                }
                assert inputText.getText() != null;
                if (inputText.getText().length() == 0) {
                    return;
                }
                if (inputText.getText().toString().equalsIgnoreCase(correctAnswer)) {
                    MainActivity.getInstance().setCorrect(question);
                    if (question.hasExplanation()) {
                        _continue = true;
                        closeKeyBoard();
                        disableEditText();
                        showInfoMessage(false);
                        validate.setText(R.string.continuer);
                        MainActivity.getInstance().setSessionState(SessionState.ENDING);
                    } else {
                        restartActivity();
                    }
                } else {
                    _continue = true;
                    closeKeyBoard();
                    disableEditText();
                    showErrorMessage(false);
                    MainActivity.getInstance().setIncorrect(question, inputText.getText().toString());
                    validate.setText(R.string.continuer);
                    MainActivity.getInstance().setSessionState(SessionState.ENDING);
                }
            }
        });
    }

    private void initCloseButton() {
        ImageView close = findViewById(R.id.close);
        close.setOnClickListener(view -> finish());
    }
}