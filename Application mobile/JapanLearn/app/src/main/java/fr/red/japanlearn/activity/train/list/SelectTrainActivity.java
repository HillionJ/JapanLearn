package fr.red.japanlearn.activity.train.list;

import static java.lang.String.format;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.material.button.MaterialButton;

import fr.red.japanlearn.R;
import fr.red.japanlearn.activity.train.TrainActivity;
import fr.red.japanlearn.utils.AnswerType;
import fr.red.japanlearn.utils.IHM;
import fr.red.japanlearn.utils.SessionState;
import fr.red.japanlearn.utils.mistake.Mistakes;
import fr.red.japanlearn.utils.session.CharType;
import fr.red.japanlearn.utils.session.Session;

public class SelectTrainActivity extends TrainActivity {

    protected LinearLayout select_container;
    protected MaterialButton selectedOption = null;
    private boolean isEditable = true;

    @Override
    protected void onCreateChild() {
        initLayout(R.layout.activity_train_select);
        initVars();

        if (Session.getCurrentSession().getSessionState() == SessionState.ENDING) {
            if (question.isCorrect() && question.hasExplanation()) {
                showInfoMessage(question, true);
                disableAnswerEdit();
            } else if (!question.isCorrect()) {
                showErrorMessage(true);
                disableAnswerEdit();
            }
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    protected void initVars() {
        ihm = IHM.getIHM();
        ihm.ajouterIHM(this);

        Mistakes mistakes = Mistakes.getMistakes();

        question = Session.getCurrentSession().getCurrentGuessAnswerData();
        TextView questionText = findViewById(R.id.guess);
        questionText.setText(question.getQuestion());

        TextView charTypeText = findViewById(R.id.type);
        CharType charType = CharType.fromID(question.getIDCharType());
        assert charType != null;
        charTypeText.setText(charType.getName());

        select_container = findViewById(R.id.select_container);
        select_container.removeAllViews();
        for (String option : question.getPossibleAnswers()) {
            MaterialButton btn = craftButton(option);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!isEditable) return;
                    if (selectedOption != null && selectedOption.equals(btn)) {
                        selectedOption = null;
                        btn.setStrokeColor(ColorStateList.valueOf(Color.GRAY));
                        btn.setStrokeWidth(dpToPx(2, SelectTrainActivity.this));
                    } else {
                        selectedOption = btn;
                        for (int i = 0; i < select_container.getChildCount(); i++) {
                            MaterialButton mb = (MaterialButton) select_container.getChildAt(i);
                            if (mb.equals(btn)) continue;
                            mb.setStrokeColor(ColorStateList.valueOf(Color.GRAY));
                            mb.setStrokeWidth(dpToPx(2, SelectTrainActivity.this));
                        }
                        btn.setStrokeColor(ColorStateList.valueOf(Color.BLACK));
                        btn.setStrokeWidth(dpToPx(4, SelectTrainActivity.this));
                    }
                }
            });
            select_container.addView(btn);
        }

        correctAnswer = question.getAnswer();

        errorContainer = findViewById(R.id.errorContainer);
        errorText = findViewById(R.id.errorText);
        errorTitle = findViewById(R.id.errorTitle);

        TextView session_progress = findViewById(R.id.session_progress);
        int maxNumber = Session.getCurrentSession().getMaxNumberOfQuestions();
        int currentNumber = maxNumber - Session.getCurrentSession().getDynamicQuestions().size() + 1;
        session_progress.setText(format(getString(R.string.quiz_progress_format), currentNumber, maxNumber));

        TextView wrong_label = findViewById(R.id.wrong_label);
        if (question.isCorrection()) {
            wrong_label.setText(R.string.error_label);
            wrong_label.setVisibility(View.VISIBLE);
        } else if (mistakes.isMistake(question)) {
            wrong_label.setText(R.string.frequent_label);
            wrong_label.setTextColor(getResources().getColor(R.color.frequent_mistake));
            wrong_label.setVisibility(View.VISIBLE);
        }
        validate = findViewById(R.id.validate);

        initValidationButton(validate);

        initCloseButton();
    }

    /*
android:layout_width="match_parent"
android:layout_height="wrap_content"
    */

    @NonNull
    private MaterialButton craftButton(String option) {
        boolean portait = getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;

        MaterialButton btn = new MaterialButton(this, null, com.google.android.material.R.attr.materialButtonOutlinedStyle);
        btn.setText(option);
        btn.setTextSize(TypedValue.COMPLEX_UNIT_SP, portait ? 20 : 15);
        btn.setTextColor(Color.BLACK);

        btn.setStrokeColor(ColorStateList.valueOf(Color.GRAY));
        btn.setStrokeWidth(dpToPx(2, this));
        btn.setForeground(null);

        int pad = dpToPx(portait ? 15 : 10, this);
        btn.setPadding(pad, pad, pad, pad);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        int margin = dpToPx(portait ? 10 : 0, this);
        lp.setMargins(margin, margin, margin, margin);
        btn.setLayoutParams(lp);
        return btn;
    }

    @Override
    protected void disableAnswerEdit() {
        isEditable = true;
    }

    protected AnswerType isValidInput() {
        if (selectedOption == null) return AnswerType.INVALID;
        if (Session.getCurrentSession().getCurrentGuessAnswerData().isValidAnswer(selectedOption.getText().toString())) {
            Session.getCurrentSession().setCorrect(question);
            return AnswerType.CORRECT;
        }
        Session.getCurrentSession().setIncorrect(question, selectedOption.getText().toString());
        return AnswerType.INCORRECT;
    }

    private int dpToPx(int dp, android.content.Context context) {
        return Math.round(dp * context.getResources().getDisplayMetrics().density);
    }
}
