package fr.red.japanlearn.utils.chars;

import java.util.ArrayList;
import java.util.List;

import fr.red.japanlearn.utils.Question;

public class Hiraganas {

    public static List<Question> hiraganaMap = new ArrayList<>();
    public static List<Question> hiraganaCombinedMap = new ArrayList<>();

    static {
        // voyelles
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "あ", "a"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "い", "i"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "う", "u"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "え", "e"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "お", "o"));

        // k
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "か", "ka"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "き", "ki"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "く", "ku"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "け", "ke"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "こ", "ko"));

        // g
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "が", "ga"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ぎ", "gi"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ぐ", "gu"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "げ", "ge"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ご", "go"));

        // s
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "さ", "sa"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "し", "shi"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "す", "su"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "せ", "se"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "そ", "so"));

        // z
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ざ", "za"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "じ", "ji"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ず", "zu"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ぜ", "ze"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ぞ", "zo"));

        // t
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "た", "ta"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ち", "chi"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "つ", "tsu"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "て", "te"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "と", "to"));

        // d
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "だ", "da"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ぢ", "ji")); // utilisé rarement
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "づ", "zu")); // utilisé rarement
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "で", "de"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ど", "do"));

        // n
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "な", "na"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "に", "ni"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ぬ", "nu"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ね", "ne"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "の", "no"));

        // h
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "は", "ha"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ひ", "hi"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ふ", "fu"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "へ", "he"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ほ", "ho"));

        // b
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ば", "ba"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "び", "bi"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ぶ", "bu"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "べ", "be"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ぼ", "bo"));

        // p
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ぱ", "pa"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ぴ", "pi"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ぷ", "pu"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ぺ", "pe"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ぽ", "po"));

        // m
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ま", "ma"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "み", "mi"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "む", "mu"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "め", "me"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "も", "mo"));

        // y
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "や", "ya"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ゆ", "yu"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "よ", "yo"));

        // r
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ら", "ra"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "り", "ri"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "る", "ru"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "れ", "re"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ろ", "ro"));

        // w
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "わ", "wa"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "を", "wo")); // utilisé comme particule "o"

        // n
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ん", "n"));

        // petites lettres (utilisées pour créer des sons combinés)
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ぁ", "a"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ぃ", "i"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ぅ", "u"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ぇ", "e"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ぉ", "o"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ゃ", "ya"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ゅ", "yu"));
        hiraganaMap.add(new Question(CharOrigin.HIRAGANA, "ょ", "yo"));
    }

    static {
        // k+ya/yu/yo
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "きゃ", "kya"));
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "きゅ", "kyu"));
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "きょ", "kyo"));

        // g+ya/yu/yo
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "ぎゃ", "gya"));
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "ぎゅ", "gyu"));
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "ぎょ", "gyo"));

        // s+ya/yu/yo
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "しゃ", "sha"));
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "しゅ", "shu"));
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "しょ", "sho"));

        // z+ya/yu/yo
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "じゃ", "ja"));
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "じゅ", "ju"));
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "じょ", "jo"));

        // t+ya/yu/yo
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "ちゃ", "cha"));
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "ちゅ", "chu"));
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "ちょ", "cho"));

        // d+ya/yu/yo
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "ぢゃ", "ja")); // très rare
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "ぢゅ", "ju"));
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "ぢょ", "jo"));

        // n+ya/yu/yo
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "にゃ", "nya"));
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "にゅ", "nyu"));
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "にょ", "nyo"));

        // h+ya/yu/yo
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "ひゃ", "hya"));
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "ひゅ", "hyu"));
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "ひょ", "hyo"));

        // b+ya/yu/yo
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "びゃ", "bya"));
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "びゅ", "byu"));
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "びょ", "byo"));

        // p+ya/yu/yo
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "ぴゃ", "pya"));
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "ぴゅ", "pyu"));
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "ぴょ", "pyo"));

        // m+ya/yu/yo
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "みゃ", "mya"));
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "みゅ", "myu"));
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "みょ", "myo"));

        // r+ya/yu/yo
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "りゃ", "rya"));
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "りゅ", "ryu"));
        hiraganaCombinedMap.add(new Question(CharOrigin.HIRAGANA, "りょ", "ryo"));
    }

    public static void addHiraganas(List<Question> currentSession, boolean addHiragana, boolean addComposition) {
        if (addHiragana) {
            currentSession.addAll(Hiraganas.hiraganaMap);
            if (addComposition) {
                currentSession.addAll(Hiraganas.hiraganaCombinedMap);
            }
        }
    }

    public static List<Question> getMixUpQuestions(String wrongAnswer, boolean reversed) {
        List<Question> mixUpQuestions = new ArrayList<>();

        hiraganaMap.stream().filter(question -> question.getAnswer(reversed).equals(wrongAnswer)).forEach(mixUpQuestions::add);
        hiraganaCombinedMap.stream().filter(question -> question.getAnswer(reversed).equals(wrongAnswer)).forEach(mixUpQuestions::add);

        return mixUpQuestions;
    }
}
