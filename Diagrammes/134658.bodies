class MainActivity
!!!134530.java!!!	getInstance() : MainActivity
        return instance;
!!!134658.java!!!	onCreate(inout savedInstanceState : Bundle) : void
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
                currentSession.forEach(GuessAnswerData::reset);
                currentSession.clear();
                Hiraganas.addHiraganas(currentSession, hiraganaCheckBox.isChecked(), hiraganaCombinedCheckBox.isChecked());
                Katakanas.addKatakanas(currentSession, katakanaCheckBox.isChecked(), katakanaCombinedCheckBox.isChecked());
                Kanji.addKanji(currentSession, kanjiCheckBox.isChecked());

                if (currentSession.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Sélection vide", Toast.LENGTH_SHORT).show();
                    return;
                }

                nextTry();
                Intent intent = new Intent(MainActivity.this, TrainActivity.class);
                startActivity(intent);
            }
        });
!!!134786.java!!!	onStart() : void
        super.onStart();
        sessionState = SessionState.HOME;
!!!134914.java!!!	onResume() : void
        super.onResume();
        sessionState = SessionState.HOME;
!!!135042.java!!!	nextTry() : void
        sessionState = SessionState.TRAINING;
        guessAnswerData = currentSession.get(new Random().nextInt(currentSession.size()));
        if (!guessAnswerData.isCorrection()){
            guessAnswerData.setReversed(new Random().nextBoolean());
        }
!!!135170.java!!!	removeGuessAnswerData(inout guessAnswerData : GuessAnswerData) : void
        currentSession.remove(guessAnswerData);
!!!135298.java!!!	getCurrentGuessAnswerData() : GuessAnswerData
        return guessAnswerData;
!!!135426.java!!!	getSessionState() : SessionState
        return sessionState;
!!!135554.java!!!	setSessionState(inout sessionState : SessionState) : void
        this.sessionState = sessionState;
