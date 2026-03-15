package fr.red.japanlearn.activity.train.list;

import static java.lang.String.format;

import android.content.res.Configuration;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import fr.red.japanlearn.R;
import fr.red.japanlearn.activity.train.TrainActivity;
import fr.red.japanlearn.utils.AnswerType;
import fr.red.japanlearn.utils.IHM;
import fr.red.japanlearn.utils.SessionState;
import fr.red.japanlearn.utils.mistake.Mistakes;
import fr.red.japanlearn.utils.session.CharType;
import fr.red.japanlearn.utils.session.Session;

public class TextTrainActivity extends TrainActivity {

    protected TextInputEditText inputText;

    @Override
    protected void onCreateChild() {
        initLayout(R.layout.activity_train_text);
        initVars();

        closeKeyBoard(inputText);
        if (Session.getCurrentSession().getSessionState() == SessionState.ENDING) {
            if (question.isCorrect() && question.hasExplanation()) {
                showInfoMessage(true);
                disableAnswerEdit();
            } else if (!question.isCorrect()) {
                showErrorMessage(true);
                disableAnswerEdit();
            }
        } else {
            updateKeyboardLang(inputText);
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                openKeyboard(inputText);
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

        inputText = findViewById(R.id.textInput);
        inputText.setText("");
        inputText.requestFocus();

        correctAnswer = question.getAnswer();
        Log.d("_RED", "correctAnswer: " + correctAnswer);

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

    @Override
    protected void disableAnswerEdit() {
        inputText.setEnabled(false);
    }

    protected AnswerType isValidInput() {
        assert inputText.getText() != null;

        if (inputText.getText().length() == 0) return AnswerType.INCORRECT;
        if (Session.getCurrentSession().getCurrentGuessAnswerData().isValidAnswer(inputText.getText().toString())) {
            closeKeyBoard(inputText);
            Session.getCurrentSession().setCorrect(question);
            return AnswerType.CORRECT;
        }
        Session.getCurrentSession().setIncorrect(question, inputText.getText().toString());
        return AnswerType.INCORRECT;
    }
}
