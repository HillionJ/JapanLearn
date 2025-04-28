package fr.red.japanlearn;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import fr.red.japanlearn.activity.TrainActivity;
import fr.red.japanlearn.utils.Hiraganas;

public class MainActivity extends AppCompatActivity {

    private static MainActivity instance;

    public static MainActivity getInstance() {
        return instance;
    }

    private CheckBox hiraganaCheckBox, katakanaCheckBox, kanjiCheckBox, hiraganaCombinedCheckBox;
    private Map<String, String> currentSession = new HashMap<>();
    private boolean reversed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.background), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        instance = this;

        hiraganaCheckBox = findViewById(R.id.hiraganaCheckBox);
        katakanaCheckBox = findViewById(R.id.katakanaCheckBox);
        kanjiCheckBox = findViewById(R.id.kanjiCheckBox);
        hiraganaCombinedCheckBox = findViewById(R.id.hiraganaCombinedCheckBox);

        Button startButton = findViewById(R.id.start);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentSession.clear();
                if (hiraganaCheckBox.isChecked()) {
                    currentSession.putAll(Hiraganas.hiraganaMap);
                    if (hiraganaCombinedCheckBox.isChecked()) {
                        currentSession.putAll(Hiraganas.hiraganaCombinedMap);
                    }
                }

                Intent intent = new Intent(MainActivity.this, TrainActivity.class);
                startActivity(intent);
            }
        });
    }

    public String[] getRandom() {
        String[] random = new String[2];
        int randomIndex = (int) (Math.random() * currentSession.size());
        int i = 0;
        for (Map.Entry<String, String> entry : currentSession.entrySet()) {
            if (i == randomIndex) {
                reversed = new Random().nextBoolean();
                random[reversed ? 0 : 1] = entry.getKey();
                random[reversed ? 1 : 0] = entry.getValue();
                currentSession.remove(entry.getKey());
                break;
            }
            i++;
        }
        return random;
    }

    public boolean isReversed() {
        return reversed;
    }
}