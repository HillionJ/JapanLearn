package fr.red.japanlearn.activity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import fr.red.japanlearn.R;
import fr.red.japanlearn.utils.IHM;
import fr.red.japanlearn.utils.Question;

public class StatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLayout();
        initVars();
    }

    private void initLayout() {
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_stats);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void initVars() {
        IHM ihm = IHM.getIHM();
        ihm.ajouterIHM(this);

        initCloseButton();
        initContinueButton();
        initProgressBar();
        initPercentage();
    }

    private void initPercentage() {
        List<Question> questions = MainActivity.getInstance().getQuestions();
        double correct = 0;
        for (Question question : questions) {
            if (!question.wasIncorrect()) {
                correct++;
            }
        }
        int percentage = (int) (correct / (double) questions.size() * 100.0);
        TextView progressPercent = findViewById(R.id.progress_percent);
        Log.d("_RED", "initPercentage: " + percentage);
        progressPercent.setText(percentage + "%");
    }

    public void initProgressBar() {
        List<Question> questions = MainActivity.getInstance().getQuestions();
        LinearLayout progressBarLayout = findViewById(R.id.customProgressBar);
        progressBarLayout.removeAllViews();

        for (int i = 0; i < questions.size(); i++) {
            View segment = new View(this);

            // Déterminer le background selon la position
            if (questions.size() == 1) {
                segment.setBackgroundResource(R.drawable.progress_segment_single);
            } else if (i == 0) {
                segment.setBackgroundResource(R.drawable.progress_segment_left);
            } else if (i == questions.size() - 1) {
                segment.setBackgroundResource(R.drawable.progress_segment_right);
            } else {
                segment.setBackgroundResource(R.drawable.progress_segment_middle);
            }

            int couleur = questions.get(i).wasIncorrect() ? Color.RED : Color.GREEN;
            segment.getBackground().setColorFilter(couleur, PorterDuff.Mode.SRC_IN);

            // Ajouter avec poids égal
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f);
            if (i != questions.size() - 1) params.setMarginEnd(2); // petit espacement visuel
            segment.setLayoutParams(params);

            progressBarLayout.addView(segment);
        }

    }

    public void initContinueButton() {
        Button continueButton = findViewById(R.id.stats_continue);
        continueButton.setOnClickListener(view -> finish());
    }

    private void initCloseButton() {
        ImageView close = findViewById(R.id.close);
        close.setOnClickListener(view -> finish());
    }
}