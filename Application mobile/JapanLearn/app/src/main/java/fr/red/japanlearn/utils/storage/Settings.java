package fr.red.japanlearn.utils.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.Map;

import fr.red.japanlearn.utils.IHM;

public class Settings {

    private static Settings instance;

    public static Settings getSettings() {
        if (instance == null)
            instance = new Settings();
        return instance;
    }

    private boolean hiraganaCheckBox, katakanaCheckBox, kanjiCheckBox, hiraganaCombinedCheckBox, katakanaCombinedCheckBox;
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
        hiraganaCombinedCheckBox = prefs.getBoolean("hiraganaCombinedCheckBox", false);
        katakanaCheckBox = prefs.getBoolean("katakanaCheckBox", false);
        katakanaCombinedCheckBox = prefs.getBoolean("katakanaCombinedCheckBox", false);
        kanjiCheckBox = prefs.getBoolean("kanjiCheckBox", false);
        numberOfQuestions = prefs.getString("numberOfQuestions", "");
    }

    @SuppressWarnings("ConstantConditions")
    public void saveSettings(Map<String, Object> settings) {
        SharedPreferences prefs = ihm.getActiviteActive().getSharedPreferences("Settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        hiraganaCheckBox = ((CheckBox)settings.get("hiraganaCheckBox")).isChecked();
        hiraganaCombinedCheckBox = ((CheckBox)settings.get("hiraganaCombinedCheckBox")).isChecked();
        katakanaCheckBox = ((CheckBox)settings.get("katakanaCheckBox")).isChecked();
        katakanaCombinedCheckBox = ((CheckBox)settings.get("katakanaCombinedCheckBox")).isChecked();
        kanjiCheckBox = ((CheckBox)settings.get("kanjiCheckBox")).isChecked();
        numberOfQuestions = ((EditText)settings.get("numberOfQuestions")).getText().toString();

        editor.putBoolean("hiraganaCheckBox", hiraganaCheckBox);
        editor.putBoolean("hiraganaCombinedCheckBox", hiraganaCombinedCheckBox);
        editor.putBoolean("katakanaCheckBox", katakanaCheckBox);
        editor.putBoolean("katakanaCombinedCheckBox", katakanaCombinedCheckBox);
        editor.putBoolean("kanjiCheckBox", kanjiCheckBox);
        editor.putString("numberOfQuestions", numberOfQuestions);

        editor.apply();
    }

    @SuppressWarnings("ConstantConditions")
    public boolean isModified(Map<String, Object> settings) {
        SharedPreferences prefs = ihm.getActiviteActive().getSharedPreferences("Settings", Context.MODE_PRIVATE);
        return ((CheckBox)settings.get("hiraganaCheckBox")).isChecked() != prefs.getBoolean("hiraganaCheckBox", false)
                || ((CheckBox)settings.get("hiraganaCombinedCheckBox")).isChecked() != prefs.getBoolean("hiraganaCombinedCheckBox", false)
                || ((CheckBox)settings.get("katakanaCheckBox")).isChecked() != prefs.getBoolean("katakanaCheckBox", false)
                || ((CheckBox)settings.get("katakanaCombinedCheckBox")).isChecked() != prefs.getBoolean("katakanaCombinedCheckBox", false)
                || ((CheckBox)settings.get("kanjiCheckBox")).isChecked() != prefs.getBoolean("kanjiCheckBox", false)
                || !((EditText)settings.get("numberOfQuestions")).getText().toString().equals(prefs.getString("numberOfQuestions", ""));
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

    public boolean isHiraganaCombined() {
        return hiraganaCombinedCheckBox;
    }

    public boolean isKatakana() {
        return katakanaCheckBox;
    }

    public boolean isKatakanaCombined() {
        return katakanaCombinedCheckBox;
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
}
