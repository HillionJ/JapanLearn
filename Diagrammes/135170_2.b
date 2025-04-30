class TrainActivity
!!!135682.java!!!	onCreate(inout savedInstanceState : Bundle) : void
        super.onCreate(savedInstanceState);

        initLayout();
        initVars();

        closeKeyBoard();
        if (MainActivity.getInstance().getSessionState() == SessionState.ENDING) {
            if (guessAnswerData.isCorrect() && guessAnswerData.hasExplanation()) {
                showInfoMessage(true);
                disableEditText();
            } else if (!guessAnswerData.isCorrect()) {
                showErrorMessage(true);
                disableEditText();
            }
        } else {
            updateKeyboardLang();
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                openKeyboardAfter(200);
            }
        }
!!!135810.java!!!	disableEditText() : void
        inputText.setEnabled(false);
!!!135938.java!!!	showErrorMessage(inout instantDisplay : boolean) : void
        showMessage(correctAnswer, false, instantDisplay);
!!!136066.java!!!	showInfoMessage(inout instantDisplay : boolean) : void
        showMessage(guessAnswerData.getExplanation(), true, instantDisplay);
!!!136194.java!!!	showMessage(in message : String, inout goodAnswer : boolean, inout instantDisplay : boolean) : void
        if (instantDisplay) {
            displayLayout(message, goodAnswer);
            return;
        }
        Animation slideIn = AnimationUtils.loadAnimation(this, R.anim.slide_in_bottom);
        validate.setVisibility(View.INVISIBLE);

        errorContainer.postDelayed(() -> {
            displayLayout(message, goodAnswer);

            errorContainer.startAnimation(slideIn);
            validate.startAnimation(slideIn);
        }, 150);
!!!136322.java!!!	displayLayout(in message : String, inout goodAnswer : boolean) : void
        errorContainer.setBackgroundColor(getResources().getColor(goodAnswer ? R.color.good_answer : R.color.wrong_answer));
        errorText.setText(message);
        errorTitle.setText(goodAnswer ? "Signification : " : "Bonne réponse : ");
        errorContainer.setVisibility(View.VISIBLE);
        validate.setVisibility(View.VISIBLE);
!!!136450.java!!!	restartActivity() : void
        MainActivity.getInstance().nextTry();
        finish();
        startActivity(getIntent());
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
!!!136578.java!!!	openKeyboardAfter(in delayMillis : int) : boolean
        return inputText.postDelayed(() -> {
            inputText.requestFocus();
            InputMethodManager imm2 = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

            // Force vraiment l'ouverture du clavier
            if (imm2 != null) {
                imm2.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
            }
        }, delayMillis);
!!!136706.java!!!	updateKeyboardLang() : void
        inputText.setImeHintLocales(new android.os.LocaleList(new java.util.Locale(!guessAnswerData.isReversed() ? "fr" : "ja")));
!!!136834.java!!!	closeKeyBoard() : void
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(inputText.getWindowToken(), 0);
!!!136962.java!!!	initLayout() : void
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_train);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.background), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        SoftKeyboardInput.handleSoftKeyboard(this);
!!!137090.java!!!	initVars() : void

        guessAnswerData = MainActivity.getInstance().getCurrentGuessAnswerData();
        guess = findViewById(R.id.guess);
        guess.setText(guessAnswerData.getGuess());

        inputText = findViewById(R.id.textInput);
        inputText.setText("");
        inputText.requestFocus();

        correctAnswer = guessAnswerData.getAnswer();
        Log.d("_RED", "correctAnswer: " + correctAnswer);

        errorContainer = findViewById(R.id.errorContainer);
        errorText = findViewById(R.id.errorText);
        errorTitle = findViewById(R.id.errorTitle);

        initValidationButton();

        initCloseButton();
!!!137218.java!!!	initValidationButton() : void
        validate = findViewById(R.id.validate);
        if (MainActivity.getInstance().getSessionState() == SessionState.ENDING) {
            validate.setText(R.string.continuer);
        }

        validate.setOnClickListener(new View.OnClickListener() {
            boolean _continue = MainActivity.getInstance().getSessionState() == SessionState.ENDING;
            @Override
            public void onClick(View view) {
                if (_continue) {
                    restartActivity();
                    return;
                }
                if (inputText.getText().length() == 0) {
                    return;
                }
                if (inputText.getText().toString().equalsIgnoreCase(correctAnswer)) {
                    guessAnswerData.correct();
                    MainActivity.getInstance().removeGuessAnswerData(guessAnswerData);
                    if (guessAnswerData.hasExplanation()) {
                        _continue = true;
                        closeKeyBoard();
                        disableEditText();
                        showInfoMessage(false);
                        validate.setText(R.string.continuer);
                        MainActivity.getInstance().setSessionState(SessionState.ENDING);
                    } else {
                        restartActivity();
                    }
                } else {
                    _continue = true;
                    closeKeyBoard();
                    disableEditText();
                    showErrorMessage(false);
                    guessAnswerData.requiredCorrection();
                    validate.setText(R.string.continuer);
                    MainActivity.getInstance().setSessionState(SessionState.ENDING);
                }
            }
        });
!!!137346.java!!!	initCloseButton() : void
        ImageView close = findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
