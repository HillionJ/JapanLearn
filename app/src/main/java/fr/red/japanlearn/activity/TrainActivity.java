package fr.red.japanlearn.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import fr.red.japanlearn.MainActivity;
import fr.red.japanlearn.R;

public class TrainActivity extends AppCompatActivity {

    private String correctAnswer;
    private TextView guess;
    private TextInputEditText inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_train);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.background), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        guess = findViewById(R.id.guess);
        inputText = findViewById(R.id.textInput);
        Button validate = findViewById(R.id.validate);
        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputText.getText().length() == 0) {
                    return;
                }
                Log.d("_RED", inputText.getText().toString().length() + "");
                Log.d("_RED", inputText.getText().toString().trim().length() + "");
                Log.d("_RED", correctAnswer.length() + "");
                if (inputText.getText().toString().trim().equalsIgnoreCase(correctAnswer)) {
                    Toast.makeText(TrainActivity.this, "Bonne réponse !", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(TrainActivity.this, "Faux ! Réponse: " + correctAnswer, Toast.LENGTH_SHORT).show();
                }
                restartActivity();
            }
        });

        ImageView close = findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        nextTry();
    }

    public void nextTry() {
        String[] random = MainActivity.getInstance().getRandom();
        guess.setText(random[0]);
        correctAnswer = random[1];
        inputText.setText("");
        inputText.requestFocus();

        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        // 1. Fermer d'abord
        imm.hideSoftInputFromWindow(inputText.getWindowToken(), 0);

        // 2. Ensuite changer la langue
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            inputText.setImeHintLocales(
                    new android.os.LocaleList(new java.util.Locale(MainActivity.getInstance().isReversed() ? "fr" : "ja"))
            );
        }

        // 3. Et enfin rouvrir
        inputText.postDelayed(() -> {
            InputMethodManager imm2 = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm2.showSoftInput(inputText, InputMethodManager.SHOW_IMPLICIT);
        }, 100); // petit délai pour laisser le temps de tout mettre à jour
    }

    public void restartActivity() {
        finish();
        overridePendingTransition(0, 0); // Pas d'animation de sortie
        startActivity(getIntent());
        overridePendingTransition(0, 0); // Pas d'animation d'entrée
    }

}