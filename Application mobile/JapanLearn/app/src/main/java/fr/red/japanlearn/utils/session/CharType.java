package fr.red.japanlearn.utils.session;

public class CharType {

    public static final CharType HIRAGANA = new CharType(1, "Hiragana");
    public static final CharType KATAKANA = new CharType(2, "Katakana");
    public static final CharType KANJI = new CharType(3, "Kanji");
    public static final CharType VOCABULARY = new CharType(4, "Vocabulaire");

    private static final CharType[] values = new CharType[] {HIRAGANA, KATAKANA, KANJI, VOCABULARY};

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

    public static CharType fromID(int id) {
        for (CharType ct : values) {
            if (ct.idChar == id) return ct;
        }
        return null;
    }
}
