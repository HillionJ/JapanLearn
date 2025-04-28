package fr.red.japanlearn.utils;

import java.util.HashMap;
import java.util.Map;

public class Hiraganas {

    public static HashMap<String, String> hiraganaMap = new HashMap<>();
    public static HashMap<String, String> hiraganaCombinedMap = new HashMap<>();

    static {
        // voyelles
        hiraganaMap.put("あ", "a");
        hiraganaMap.put("い", "i");
        hiraganaMap.put("う", "u");
        hiraganaMap.put("え", "e");
        hiraganaMap.put("お", "o");

        // k
        hiraganaMap.put("か", "ka");
        hiraganaMap.put("き", "ki");
        hiraganaMap.put("く", "ku");
        hiraganaMap.put("け", "ke");
        hiraganaMap.put("こ", "ko");

        // g
        hiraganaMap.put("が", "ga");
        hiraganaMap.put("ぎ", "gi");
        hiraganaMap.put("ぐ", "gu");
        hiraganaMap.put("げ", "ge");
        hiraganaMap.put("ご", "go");

        // s
        hiraganaMap.put("さ", "sa");
        hiraganaMap.put("し", "shi");
        hiraganaMap.put("す", "su");
        hiraganaMap.put("せ", "se");
        hiraganaMap.put("そ", "so");

        // z
        hiraganaMap.put("ざ", "za");
        hiraganaMap.put("じ", "ji");
        hiraganaMap.put("ず", "zu");
        hiraganaMap.put("ぜ", "ze");
        hiraganaMap.put("ぞ", "zo");

        // t
        hiraganaMap.put("た", "ta");
        hiraganaMap.put("ち", "chi");
        hiraganaMap.put("つ", "tsu");
        hiraganaMap.put("て", "te");
        hiraganaMap.put("と", "to");

        // d
        hiraganaMap.put("だ", "da");
        hiraganaMap.put("ぢ", "ji"); // utilisé rarement
        hiraganaMap.put("づ", "zu"); // utilisé rarement
        hiraganaMap.put("で", "de");
        hiraganaMap.put("ど", "do");

        // n
        hiraganaMap.put("な", "na");
        hiraganaMap.put("に", "ni");
        hiraganaMap.put("ぬ", "nu");
        hiraganaMap.put("ね", "ne");
        hiraganaMap.put("の", "no");

        // h
        hiraganaMap.put("は", "ha");
        hiraganaMap.put("ひ", "hi");
        hiraganaMap.put("ふ", "fu");
        hiraganaMap.put("へ", "he");
        hiraganaMap.put("ほ", "ho");

        // b
        hiraganaMap.put("ば", "ba");
        hiraganaMap.put("び", "bi");
        hiraganaMap.put("ぶ", "bu");
        hiraganaMap.put("べ", "be");
        hiraganaMap.put("ぼ", "bo");

        // p
        hiraganaMap.put("ぱ", "pa");
        hiraganaMap.put("ぴ", "pi");
        hiraganaMap.put("ぷ", "pu");
        hiraganaMap.put("ぺ", "pe");
        hiraganaMap.put("ぽ", "po");

        // m
        hiraganaMap.put("ま", "ma");
        hiraganaMap.put("み", "mi");
        hiraganaMap.put("む", "mu");
        hiraganaMap.put("め", "me");
        hiraganaMap.put("も", "mo");

        // y
        hiraganaMap.put("や", "ya");
        hiraganaMap.put("ゆ", "yu");
        hiraganaMap.put("よ", "yo");

        // r
        hiraganaMap.put("ら", "ra");
        hiraganaMap.put("り", "ri");
        hiraganaMap.put("る", "ru");
        hiraganaMap.put("れ", "re");
        hiraganaMap.put("ろ", "ro");

        // w
        hiraganaMap.put("わ", "wa");
        hiraganaMap.put("を", "wo"); // utilisé comme particule "o"

        // n
        hiraganaMap.put("ん", "n");

        // petites lettres (utilisées pour créer des sons combinés)
        hiraganaMap.put("ぁ", "a");
        hiraganaMap.put("ぃ", "i");
        hiraganaMap.put("ぅ", "u");
        hiraganaMap.put("ぇ", "e");
        hiraganaMap.put("ぉ", "o");
        hiraganaMap.put("ゃ", "ya");
        hiraganaMap.put("ゅ", "yu");
        hiraganaMap.put("ょ", "yo");
    }

    static {
        // k+ya/yu/yo
        hiraganaCombinedMap.put("きゃ", "kya");
        hiraganaCombinedMap.put("きゅ", "kyu");
        hiraganaCombinedMap.put("きょ", "kyo");

        // g+ya/yu/yo
        hiraganaCombinedMap.put("ぎゃ", "gya");
        hiraganaCombinedMap.put("ぎゅ", "gyu");
        hiraganaCombinedMap.put("ぎょ", "gyo");

        // s+ya/yu/yo
        hiraganaCombinedMap.put("しゃ", "sha");
        hiraganaCombinedMap.put("しゅ", "shu");
        hiraganaCombinedMap.put("しょ", "sho");

        // z+ya/yu/yo
        hiraganaCombinedMap.put("じゃ", "ja");
        hiraganaCombinedMap.put("じゅ", "ju");
        hiraganaCombinedMap.put("じょ", "jo");

        // t+ya/yu/yo
        hiraganaCombinedMap.put("ちゃ", "cha");
        hiraganaCombinedMap.put("ちゅ", "chu");
        hiraganaCombinedMap.put("ちょ", "cho");

        // d+ya/yu/yo
        hiraganaCombinedMap.put("ぢゃ", "ja"); // très rare
        hiraganaCombinedMap.put("ぢゅ", "ju");
        hiraganaCombinedMap.put("ぢょ", "jo");

        // n+ya/yu/yo
        hiraganaCombinedMap.put("にゃ", "nya");
        hiraganaCombinedMap.put("にゅ", "nyu");
        hiraganaCombinedMap.put("にょ", "nyo");

        // h+ya/yu/yo
        hiraganaCombinedMap.put("ひゃ", "hya");
        hiraganaCombinedMap.put("ひゅ", "hyu");
        hiraganaCombinedMap.put("ひょ", "hyo");

        // b+ya/yu/yo
        hiraganaCombinedMap.put("びゃ", "bya");
        hiraganaCombinedMap.put("びゅ", "byu");
        hiraganaCombinedMap.put("びょ", "byo");

        // p+ya/yu/yo
        hiraganaCombinedMap.put("ぴゃ", "pya");
        hiraganaCombinedMap.put("ぴゅ", "pyu");
        hiraganaCombinedMap.put("ぴょ", "pyo");

        // m+ya/yu/yo
        hiraganaCombinedMap.put("みゃ", "mya");
        hiraganaCombinedMap.put("みゅ", "myu");
        hiraganaCombinedMap.put("みょ", "myo");

        // r+ya/yu/yo
        hiraganaCombinedMap.put("りゃ", "rya");
        hiraganaCombinedMap.put("りゅ", "ryu");
        hiraganaCombinedMap.put("りょ", "ryo");
    }

    public static void addHiraganas(Map<String, String> currentSession, boolean addHiragana, boolean addComposition) {
        if (addHiragana) {
            currentSession.putAll(Hiraganas.hiraganaMap);
            if (addComposition) {
                currentSession.putAll(Hiraganas.hiraganaCombinedMap);
            }
        }
    }
}
