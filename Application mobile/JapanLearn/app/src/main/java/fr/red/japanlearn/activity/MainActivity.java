package fr.red.japanlearn.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import fr.red.japanlearn.R;
import fr.red.japanlearn.utils.IHM;
import fr.red.japanlearn.utils.session.Session;
import fr.red.japanlearn.utils.SessionState;

public class MainActivity extends AppCompatActivity {

    private IHM ihm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initLayout();
        iniVars();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        ihm.ajouterIHM(this);
    }

    private void iniVars() {
        ihm = IHM.init(this);
        ihm.ajouterIHM(this);

        initStartButton();
        initSettingsButton();
        initMistakesButton();
    }

    private void initLayout() {
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void initMistakesButton() {
        Button mistakesButton = findViewById(R.id.mistakesReview);
        mistakesButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MistakeActivity.class);
            startActivity(intent);
        });
    }

    public void initSettingsButton() {
        Button settingsButton = findViewById(R.id.settings);
        settingsButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        });
    }

    private void initStartButton() {
        Button startButton = findViewById(R.id.start);
        startButton.setOnClickListener(view -> Session.newSession());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Session session = Session.getCurrentSession();
        if (session != null)
            session.setSessionState(SessionState.HOME);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Session session = Session.getCurrentSession();
        if (session != null)
            session.setSessionState(SessionState.HOME);
    }
}