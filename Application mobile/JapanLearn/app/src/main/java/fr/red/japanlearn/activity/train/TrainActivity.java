package fr.red.japanlearn.activity.train;

import android.content.Intent;
import android.os.Bundle;
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
import fr.red.japanlearn.activity.StatsActivity;
import fr.red.japanlearn.utils.AnswerType;
import fr.red.japanlearn.utils.IHM;
import fr.red.japanlearn.utils.question.Question;
import fr.red.japanlearn.utils.session.Session;
import fr.red.japanlearn.utils.SessionState;
import fr.red.japanlearn.utils.SoftKeyboardInput;

public abstract class TrainActivity extends AppCompatActivity {

    protected IHM ihm;
    protected String correctAnswer;
    protected LinearLayout errorContainer;
    protected TextView errorText;
    protected TextView errorTitle;
    protected Button validate;
    protected Question question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateChild();
    }

    protected abstract void onCreateChild();

    @Override
    protected void onRestart() {
        super.onRestart();
        ihm.ajouterIHM(this);
    }

    protected void showErrorMessage(boolean instantDisplay) {
        showMessage(correctAnswer, false, instantDisplay);
    }

    protected void showInfoMessage(boolean instantDisplay) {
        showMessage(question.getExplanation(), true, instantDisplay);
    }

    protected void showMessage(String message, boolean goodAnswer,boolean instantDisplay) {
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

    @SuppressWarnings("deprecation")
    protected void displayLayout(String message, boolean goodAnswer) {
        errorContainer.setBackgroundColor(getResources().getColor(goodAnswer ? R.color.good_answer : R.color.wrong_answer));
        errorText.setText(message);
        errorTitle.setText(goodAnswer ? "Signification : " : "Bonne réponse : ");
        errorContainer.setVisibility(View.VISIBLE);
        validate.setVisibility(View.VISIBLE);
    }


    protected void restartActivity() {
        if (!Session.getCurrentSession().hasNextTry()) {
            finish();
            Intent intent = new Intent(this, StatsActivity.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            return;
        }
        Session.getCurrentSession().nextTry();
        finish();
        Intent intent = new Intent(this, Session.getCurrentSession().getNextClassType());
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    protected void openKeyboard(TextInputEditText inputText) {
        inputText.postDelayed(() -> {
            inputText.requestFocus();
            InputMethodManager imm2 = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

            // Force vraiment l'ouverture du clavier
            if (imm2 != null) {
                imm2.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
            }
        }, 200);
    }

    protected void updateKeyboardLang(TextInputEditText inputText) {
        inputText.setImeHintLocales(new android.os.LocaleList(new java.util.Locale(!question.isReversed() ? "fr" : "ja")));
    }

    protected void closeKeyBoard(TextInputEditText inputText) {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(inputText.getWindowToken(), 0);
    }

    protected void initLayout(int layout) {
        EdgeToEdge.enable(this);
        setContentView(layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        new SoftKeyboardInput(this);
    }

    protected abstract void initVars();

    protected abstract AnswerType isValidInput();

    protected void initValidationButton(Button validatationBtn) {
        boolean isEnding = Session.getCurrentSession().getSessionState() == SessionState.ENDING;
        if (isEnding) validatationBtn.setText(R.string.continuer);

        validatationBtn.setOnClickListener(new View.OnClickListener() {
            boolean changeActivity = isEnding;
            @Override
            public void onClick(View view) {
                if (changeActivity) {
                    restartActivity();
                } else {
                    AnswerType answerType = isValidInput();
                    if (answerType == AnswerType.INVALID) return;
                    changeActivity = true;
                    disableAnswerEdit();
                    if (answerType == AnswerType.CORRECT) {
                        if (question.hasExplanation()) {
                            showInfoMessage(false);
                        } else {
                            restartActivity();
                            return;
                        }
                    } else {
                        showErrorMessage(false);
                    }
                    validatationBtn.setText(R.string.continuer);
                    Session.getCurrentSession().setSessionState(SessionState.ENDING);
                }
            }
        });
    }

    protected void initCloseButton() {
        ImageView close = findViewById(R.id.close);
        close.setOnClickListener(view -> finish());
    }

    protected abstract void disableAnswerEdit();
}