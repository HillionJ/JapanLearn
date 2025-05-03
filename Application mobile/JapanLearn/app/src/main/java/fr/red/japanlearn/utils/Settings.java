package fr.red.japanlearn.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fr.red.japanlearn.utils.session.CharType;

public class Settings {

    private static Settings instance;

    public static Settings getSettings() {
        if (instance == null)
            instance = new Settings();
        return instance;
    }

    private boolean hiraganaCheckBox, katakanaCheckBox, kanjiCheckBox;
    private String numberOfQuestions;
    private final IHM ihm;

    public Settings() {
        this.ihm = IHM.getIHM();
        update();
    }

    public void update() {
        ihm.getActiviteActive();
        SharedPreferences prefs =  ihm.getActiviteActive().getSharedPreferences("Settings", Context.MODE_PRIVATE);

        hiraganaCheckBox = prefs.getBoolean("hiraganaCheckBox", false);
        katakanaCheckBox = prefs.getBoolean("katakanaCheckBox", false);
        kanjiCheckBox = prefs.getBoolean("kanjiCheckBox", false);
        numberOfQuestions = prefs.getString("numberOfQuestions", "");
    }

    @SuppressWarnings("ConstantConditions")
    public void saveSettings(Map<String, Object> settings) {
        SharedPreferences prefs = ihm.getActiviteActive().getSharedPreferences("Settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        hiraganaCheckBox = ((CheckBox)settings.get("hiraganaCheckBox")).isChecked();
        katakanaCheckBox = ((CheckBox)settings.get("katakanaCheckBox")).isChecked();
        kanjiCheckBox = ((CheckBox)settings.get("kanjiCheckBox")).isChecked();
        numberOfQuestions = ((EditText)settings.get("numberOfQuestions")).getText().toString();

        editor.putBoolean("hiraganaCheckBox", hiraganaCheckBox);
        editor.putBoolean("katakanaCheckBox", katakanaCheckBox);
        editor.putBoolean("kanjiCheckBox", kanjiCheckBox);
        editor.putString("numberOfQuestions", numberOfQuestions);

        editor.apply();
    }

    public String numberOfQuestionsStr() {
        return numberOfQuestions;
    }

    public boolean isNumberOfQuestionsSet() {
        return !numberOfQuestions.isEmpty() && getNumberOfQuestions() > 0;
    }

    public int getNumberOfQuestions() {
        return parseInt(numberOfQuestions);
    }

    public boolean isHiragana() {
        return hiraganaCheckBox;
    }

    public boolean isKatakana() {
        return katakanaCheckBox;
    }

    public boolean isKanji() {
        return kanjiCheckBox;
    }

    private int parseInt(String string) {
        int integer = 0;
        try {
            integer = Integer.parseInt(string);
        } catch (Exception ignored) {
            try {
                integer = (int)  Double.parseDouble(string);
            } catch (Exception ignored1) {
            }
        }
        return integer;
    }

    public List<CharType> getCharTypes() {
        List<CharType> charTypes = new ArrayList<>();
        if (isHiragana())
            charTypes.add(CharType.HIRAGANA);
        if (isKatakana())
            charTypes.add(CharType.KATAKANA);
        if (isKanji())
            charTypes.add(CharType.KANJI);
        return charTypes;
    }
}
