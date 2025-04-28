package fr.red.japanlearn;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import fr.red.japanlearn.activity.TrainActivity;
import fr.red.japanlearn.utils.GuessAnswerData;
import fr.red.japanlearn.utils.Hiraganas;
import fr.red.japanlearn.utils.Kanji;
import fr.red.japanlearn.utils.Katakanas;

public class MainActivity extends AppCompatActivity {

    private static MainActivity instance;

    public static MainActivity getInstance() {
        return instance;
    }

    private CheckBox hiraganaCheckBox, katakanaCheckBox, kanjiCheckBox, hiraganaCombinedCheckBox, katakanaCombinedCheckBox;
    private List<GuessAnswerData> currentSession = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.background), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        hiraganaCheckBox = findViewById(R.id.hiraganaCheckBox);
        katakanaCheckBox = findViewById(R.id.katakanaCheckBox);
        kanjiCheckBox = findViewById(R.id.kanjiCheckBox);

        hiraganaCombinedCheckBox = findViewById(R.id.hiraganaCombinedCheckBox);
        katakanaCombinedCheckBox = findViewById(R.id.katakanaCombinedCheckBox);

        Button startButton = findViewById(R.id.start);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentSession.forEach(GuessAnswerData::clearCorrection);
                currentSession.clear();
                Hiraganas.addHiraganas(currentSession, hiraganaCheckBox.isChecked(), hiraganaCombinedCheckBox.isChecked());
                Katakanas.addKatakanas(currentSession, katakanaCheckBox.isChecked(), katakanaCombinedCheckBox.isChecked());
                Kanji.addKanji(currentSession, kanjiCheckBox.isChecked());

                if (currentSession.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Sélection vide", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(MainActivity.this, TrainActivity.class);
                startActivity(intent);
            }
        });
    }

    public GuessAnswerData getRandom() {
        GuessAnswerData guessAnswerData = currentSession.get(new Random().nextInt(currentSession.size()));
        if (!guessAnswerData.isCorrection()){
            guessAnswerData.setReversed(new Random().nextBoolean());
        }
        return guessAnswerData;
    }

    public void removeGuessAnswerData(GuessAnswerData guessAnswerData) {
        currentSession.remove(guessAnswerData);
    }
}