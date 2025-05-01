package fr.red.japanlearn.utils.session;

public class CharType {

    public static final CharType HIRAGANA = new CharType(1, "Hiragana");
    public static final CharType KATAKANA = new CharType(2, "Katakana");
    public static final CharType KANJI = new CharType(3, "Kanji");

    private final int idChar;
    private final String name;

    private CharType(int idChar, String name) {
        this.idChar = idChar;
        this.name = name;
    }

    public int getID() {
        return idChar;
    }

    public String getName() {
        return name;
    }
}
