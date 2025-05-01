package fr.red.japanlearn.utils.chars;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import fr.red.japanlearn.utils.Question;

public enum CharOrigin {

    HIRAGANA, KATAKANA, KANJI;

    @NonNull
    public List<Question> getMixUpQuestions(String wrongAnswer, boolean reversed) {
        switch (this) {
            case HIRAGANA:
                return Hiraganas.getMixUpQuestions(wrongAnswer, reversed);
            case KATAKANA:
                return Katakanas.getMixUpQuestions(wrongAnswer, reversed);
            case KANJI:
                return Kanji.getMixUpQuestions(wrongAnswer, reversed);
            default:
                return new ArrayList<>();
        }
    }
}
