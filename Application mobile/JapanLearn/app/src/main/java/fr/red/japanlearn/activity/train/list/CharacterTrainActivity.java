package fr.red.japanlearn.activity.train.list;

import android.content.res.Configuration;

import com.google.android.material.textfield.TextInputEditText;

import fr.red.japanlearn.R;
import fr.red.japanlearn.activity.train.TrainActivity;
import fr.red.japanlearn.utils.AnswerType;
import fr.red.japanlearn.utils.SessionState;
import fr.red.japanlearn.utils.session.Session;

public class CharacterTrainActivity extends TrainActivity {

    protected TextInputEditText inputText;

    @Override
    protected void onCreateChild() {
        initLayout(R.layout.activity_train_text);
        initVars();

        closeKeyBoard(inputText);
        if (Session.getCurrentSession().getSessionState() == SessionState.ENDING) {
            if (question.isCorrect() && question.hasExplanation()) {
                showInfoMessage(question, true);
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
    protected void initVars() {
        super.initVars();

        inputText = findViewById(R.id.textInput);
        inputText.setText("");
        inputText.requestFocus();
    }

    @Override
    protected void disableAnswerEdit() {
        inputText.setEnabled(false);
    }

    protected AnswerType isValidInput() {
        assert inputText.getText() != null;
        if (inputText.getText().length() == 0) return AnswerType.INVALID;
        if (Session.getCurrentSession().getCurrentGuessAnswerData().isValidAnswer(inputText.getText().toString())) {
            closeKeyBoard(inputText);
            Session.getCurrentSession().setCorrect(question);
            return AnswerType.CORRECT;
        }
        Session.getCurrentSession().setIncorrect(question, inputText.getText().toString());
        return AnswerType.INCORRECT;
    }
}
