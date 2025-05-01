package fr.red.japanlearn.activity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import fr.red.japanlearn.R;
import fr.red.japanlearn.utils.Question;
import fr.red.japanlearn.utils.storage.mistake.MistakeData;
import fr.red.japanlearn.utils.storage.mistake.Mistakes;

public class MistakeActivity extends AppCompatActivity {

    private Mistakes mistakes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initLayout();
        initVars();
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

        initMistakesList();
        initCloseButton();
    }

    private void initCloseButton() {
        ImageView close = findViewById(R.id.close);
        close.setOnClickListener(view -> finish());
    }

    private void initMistakesList() {
        LinearLayout mistakesList = findViewById(R.id.mistakesList);
        mistakesList.removeAllViews();
        for (MistakeData data : mistakes.getMistakesData()) {
            addMistakeIntoList(mistakesList, data);
        }
        if (mistakes.getMistakesData().isEmpty()) {
            TextView textView = new TextView(this);
            textView.setText("Aucune erreur trouvée");
            textView.setLayoutParams(new LinearLayout.LayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)));
            textView.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
            mistakesList.addView(textView);
        }
    }

    private void addMistakeIntoList(LinearLayout mistakesList, MistakeData data) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        TextView title = new TextView(this);
        title.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        title.setText(data.getQuestion().getGuess() + "->" + data.getWrongAnswer());

        TextView count = new TextView(this);
        count.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        count.setText(String.valueOf(data.getCount()));

        linearLayout.addView(title);
        linearLayout.addView(count);
        mistakesList.addView(linearLayout);
    }
}