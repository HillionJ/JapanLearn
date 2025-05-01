package fr.red.japanlearn.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import fr.red.japanlearn.R;
import fr.red.japanlearn.utils.IHM;
import fr.red.japanlearn.utils.Question;
import fr.red.japanlearn.utils.session.Session;
import fr.red.japanlearn.utils.session.SessionType;
import fr.red.japanlearn.utils.mistake.MistakeData;
import fr.red.japanlearn.utils.mistake.MistakeType;
import fr.red.japanlearn.utils.mistake.Mistakes;

public class MistakeActivity extends AppCompatActivity {

    private Mistakes mistakes;
    private IHM ihm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initLayout();
        initVars();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        ihm.ajouterIHM(this);
        updateMistakesList();
    }

    private void initLayout() {
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mistake);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void initVars() {
        mistakes = Mistakes.getMistakes();
        ihm = IHM.getIHM();
        ihm.ajouterIHM(this);

        updateMistakesList();

        initReviewButton();
        initCloseButton();
    }

    private void initReviewButton() {
        Button reviewbButton = findViewById(R.id.mistake_review);
        reviewbButton.setOnClickListener(view -> {
            List<Question> quiz = mistakes.getMistakesQuiz();
            if (quiz.isEmpty()) {
                Toast.makeText(this, "Rien à corriger", Toast.LENGTH_SHORT).show();
                return;
            }
            Session.newSession(mistakes.getMistakesQuiz(), SessionType.CORRECTION);
        });
    }

    private void initCloseButton() {
        ImageView close = findViewById(R.id.close);
        close.setOnClickListener(view -> finish());
    }

    private void updateMistakesList() {
        LinearLayout mistakesList = findViewById(R.id.mistakesList);
        mistakesList.removeAllViews();
        for (MistakeData data : mistakes.getMistakesData()) {
            addMistakeIntoList(mistakesList, data);
        }
        if (mistakes.getMistakesData().isEmpty()) {
            displayEmptyMistakesList(mistakesList);
        }
    }

    private void displayEmptyMistakesList(@NonNull LinearLayout mistakesList) {
        TextView textView = new TextView(this);
        textView.setText(R.string.error_not_found);
        textView.setLayoutParams(new LinearLayout.LayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)));
        textView.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        mistakesList.addView(textView);
    }

    private void addMistakeIntoList(@NonNull LinearLayout mistakesList, @NonNull MistakeData data) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        TextView title = new TextView(this);
        title.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        title.setText(String.format("%s->%s", data.getQuestion().getGuess(), data.getWrongAnswer()));

        TextView count = new TextView(this);
        count.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        count.setText(String.valueOf(data.getCount()));

        linearLayout.addView(title);
        linearLayout.addView(count);
        mistakesList.addView(linearLayout);

        if (data.getType() == MistakeType.MIX_UP) {
            TextView textView = new TextView(this);
            textView.setText(String.format("%s%s", getString(R.string.mixup_with), craftMixUpStr(data)));
            mistakesList.addView(textView);
        }
    }

    @NonNull
    private static String craftMixUpStr(@NonNull MistakeData data) {
        StringBuilder mixUpStr = new StringBuilder();
        for (int i = 0; i < data.getMixUpQuestion().size(); i++) {
            mixUpStr.append(data.getMixUpQuestion().get(i).getGuess(data.getQuestion().isReversed()));
            if (i != data.getMixUpQuestion().size() - 1) {
                if (i == data.getMixUpQuestion().size() - 2) {
                    mixUpStr.append(" ou ");
                } else {
                    mixUpStr.append(", ");
                }
            }
        }
        return mixUpStr.toString();
    }
}