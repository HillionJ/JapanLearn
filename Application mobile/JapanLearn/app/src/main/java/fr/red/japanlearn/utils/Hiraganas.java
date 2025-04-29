package fr.red.japanlearn.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hiraganas {

    public static List<GuessAnswerData> hiraganaMap = new ArrayList<>();
    public static List<GuessAnswerData> hiraganaCombinedMap = new ArrayList<>();

    static {
        // voyelles
        hiraganaMap.add(new GuessAnswerData("あ", "a"));
        hiraganaMap.add(new GuessAnswerData("い", "i"));
        hiraganaMap.add(new GuessAnswerData("う", "u"));
        hiraganaMap.add(new GuessAnswerData("え", "e"));
        hiraganaMap.add(new GuessAnswerData("お", "o"));

        // k
        hiraganaMap.add(new GuessAnswerData("か", "ka"));
        hiraganaMap.add(new GuessAnswerData("き", "ki"));
        hiraganaMap.add(new GuessAnswerData("く", "ku"));
        hiraganaMap.add(new GuessAnswerData("け", "ke"));
        hiraganaMap.add(new GuessAnswerData("こ", "ko"));

        // g
        hiraganaMap.add(new GuessAnswerData("が", "ga"));
        hiraganaMap.add(new GuessAnswerData("ぎ", "gi"));
        hiraganaMap.add(new GuessAnswerData("ぐ", "gu"));
        hiraganaMap.add(new GuessAnswerData("げ", "ge"));
        hiraganaMap.add(new GuessAnswerData("ご", "go"));

        // s
        hiraganaMap.add(new GuessAnswerData("さ", "sa"));
        hiraganaMap.add(new GuessAnswerData("し", "shi"));
        hiraganaMap.add(new GuessAnswerData("す", "su"));
        hiraganaMap.add(new GuessAnswerData("せ", "se"));
        hiraganaMap.add(new GuessAnswerData("そ", "so"));

        // z
        hiraganaMap.add(new GuessAnswerData("ざ", "za"));
        hiraganaMap.add(new GuessAnswerData("じ", "ji"));
        hiraganaMap.add(new GuessAnswerData("ず", "zu"));
        hiraganaMap.add(new GuessAnswerData("ぜ", "ze"));
        hiraganaMap.add(new GuessAnswerData("ぞ", "zo"));

        // t
        hiraganaMap.add(new GuessAnswerData("た", "ta"));
        hiraganaMap.add(new GuessAnswerData("ち", "chi"));
        hiraganaMap.add(new GuessAnswerData("つ", "tsu"));
        hiraganaMap.add(new GuessAnswerData("て", "te"));
        hiraganaMap.add(new GuessAnswerData("と", "to"));

        // d
        hiraganaMap.add(new GuessAnswerData("だ", "da"));
        hiraganaMap.add(new GuessAnswerData("ぢ", "ji")); // utilisé rarement
        hiraganaMap.add(new GuessAnswerData("づ", "zu")); // utilisé rarement
        hiraganaMap.add(new GuessAnswerData("で", "de"));
        hiraganaMap.add(new GuessAnswerData("ど", "do"));

        // n
        hiraganaMap.add(new GuessAnswerData("な", "na"));
        hiraganaMap.add(new GuessAnswerData("に", "ni"));
        hiraganaMap.add(new GuessAnswerData("ぬ", "nu"));
        hiraganaMap.add(new GuessAnswerData("ね", "ne"));
        hiraganaMap.add(new GuessAnswerData("の", "no"));

        // h
        hiraganaMap.add(new GuessAnswerData("は", "ha"));
        hiraganaMap.add(new GuessAnswerData("ひ", "hi"));
        hiraganaMap.add(new GuessAnswerData("ふ", "fu"));
        hiraganaMap.add(new GuessAnswerData("へ", "he"));
        hiraganaMap.add(new GuessAnswerData("ほ", "ho"));

        // b
        hiraganaMap.add(new GuessAnswerData("ば", "ba"));
        hiraganaMap.add(new GuessAnswerData("び", "bi"));
        hiraganaMap.add(new GuessAnswerData("ぶ", "bu"));
        hiraganaMap.add(new GuessAnswerData("べ", "be"));
        hiraganaMap.add(new GuessAnswerData("ぼ", "bo"));

        // p
        hiraganaMap.add(new GuessAnswerData("ぱ", "pa"));
        hiraganaMap.add(new GuessAnswerData("ぴ", "pi"));
        hiraganaMap.add(new GuessAnswerData("ぷ", "pu"));
        hiraganaMap.add(new GuessAnswerData("ぺ", "pe"));
        hiraganaMap.add(new GuessAnswerData("ぽ", "po"));

        // m
        hiraganaMap.add(new GuessAnswerData("ま", "ma"));
        hiraganaMap.add(new GuessAnswerData("み", "mi"));
        hiraganaMap.add(new GuessAnswerData("む", "mu"));
        hiraganaMap.add(new GuessAnswerData("め", "me"));
        hiraganaMap.add(new GuessAnswerData("も", "mo"));

        // y
        hiraganaMap.add(new GuessAnswerData("や", "ya"));
        hiraganaMap.add(new GuessAnswerData("ゆ", "yu"));
        hiraganaMap.add(new GuessAnswerData("よ", "yo"));

        // r
        hiraganaMap.add(new GuessAnswerData("ら", "ra"));
        hiraganaMap.add(new GuessAnswerData("り", "ri"));
        hiraganaMap.add(new GuessAnswerData("る", "ru"));
        hiraganaMap.add(new GuessAnswerData("れ", "re"));
        hiraganaMap.add(new GuessAnswerData("ろ", "ro"));

        // w
        hiraganaMap.add(new GuessAnswerData("わ", "wa"));
        hiraganaMap.add(new GuessAnswerData("を", "wo")); // utilisé comme particule "o"

        // n
        hiraganaMap.add(new GuessAnswerData("ん", "n"));

        // petites lettres (utilisées pour créer des sons combinés)
        hiraganaMap.add(new GuessAnswerData("ぁ", "a"));
        hiraganaMap.add(new GuessAnswerData("ぃ", "i"));
        hiraganaMap.add(new GuessAnswerData("ぅ", "u"));
        hiraganaMap.add(new GuessAnswerData("ぇ", "e"));
        hiraganaMap.add(new GuessAnswerData("ぉ", "o"));
        hiraganaMap.add(new GuessAnswerData("ゃ", "ya"));
        hiraganaMap.add(new GuessAnswerData("ゅ", "yu"));
        hiraganaMap.add(new GuessAnswerData("ょ", "yo"));
    }

    static {
        // k+ya/yu/yo
        hiraganaCombinedMap.add(new GuessAnswerData("きゃ", "kya"));
        hiraganaCombinedMap.add(new GuessAnswerData("きゅ", "kyu"));
        hiraganaCombinedMap.add(new GuessAnswerData("きょ", "kyo"));

        // g+ya/yu/yo
        hiraganaCombinedMap.add(new GuessAnswerData("ぎゃ", "gya"));
        hiraganaCombinedMap.add(new GuessAnswerData("ぎゅ", "gyu"));
        hiraganaCombinedMap.add(new GuessAnswerData("ぎょ", "gyo"));

        // s+ya/yu/yo
        hiraganaCombinedMap.add(new GuessAnswerData("しゃ", "sha"));
        hiraganaCombinedMap.add(new GuessAnswerData("しゅ", "shu"));
        hiraganaCombinedMap.add(new GuessAnswerData("しょ", "sho"));

        // z+ya/yu/yo
        hiraganaCombinedMap.add(new GuessAnswerData("じゃ", "ja"));
        hiraganaCombinedMap.add(new GuessAnswerData("じゅ", "ju"));
        hiraganaCombinedMap.add(new GuessAnswerData("じょ", "jo"));

        // t+ya/yu/yo
        hiraganaCombinedMap.add(new GuessAnswerData("ちゃ", "cha"));
        hiraganaCombinedMap.add(new GuessAnswerData("ちゅ", "chu"));
        hiraganaCombinedMap.add(new GuessAnswerData("ちょ", "cho"));

        // d+ya/yu/yo
        hiraganaCombinedMap.add(new GuessAnswerData("ぢゃ", "ja")); // très rare
        hiraganaCombinedMap.add(new GuessAnswerData("ぢゅ", "ju"));
        hiraganaCombinedMap.add(new GuessAnswerData("ぢょ", "jo"));

        // n+ya/yu/yo
        hiraganaCombinedMap.add(new GuessAnswerData("にゃ", "nya"));
        hiraganaCombinedMap.add(new GuessAnswerData("にゅ", "nyu"));
        hiraganaCombinedMap.add(new GuessAnswerData("にょ", "nyo"));

        // h+ya/yu/yo
        hiraganaCombinedMap.add(new GuessAnswerData("ひゃ", "hya"));
        hiraganaCombinedMap.add(new GuessAnswerData("ひゅ", "hyu"));
        hiraganaCombinedMap.add(new GuessAnswerData("ひょ", "hyo"));

        // b+ya/yu/yo
        hiraganaCombinedMap.add(new GuessAnswerData("びゃ", "bya"));
        hiraganaCombinedMap.add(new GuessAnswerData("びゅ", "byu"));
        hiraganaCombinedMap.add(new GuessAnswerData("びょ", "byo"));

        // p+ya/yu/yo
        hiraganaCombinedMap.add(new GuessAnswerData("ぴゃ", "pya"));
        hiraganaCombinedMap.add(new GuessAnswerData("ぴゅ", "pyu"));
        hiraganaCombinedMap.add(new GuessAnswerData("ぴょ", "pyo"));

        // m+ya/yu/yo
        hiraganaCombinedMap.add(new GuessAnswerData("みゃ", "mya"));
        hiraganaCombinedMap.add(new GuessAnswerData("みゅ", "myu"));
        hiraganaCombinedMap.add(new GuessAnswerData("みょ", "myo"));

        // r+ya/yu/yo
        hiraganaCombinedMap.add(new GuessAnswerData("りゃ", "rya"));
        hiraganaCombinedMap.add(new GuessAnswerData("りゅ", "ryu"));
        hiraganaCombinedMap.add(new GuessAnswerData("りょ", "ryo"));
    }

    public static void addHiraganas(List<GuessAnswerData> currentSession, boolean addHiragana, boolean addComposition) {
        if (addHiragana) {
            currentSession.addAll(Hiraganas.hiraganaMap);
            if (addComposition) {
                currentSession.addAll(Hiraganas.hiraganaCombinedMap);
            }
        }
    }
}
