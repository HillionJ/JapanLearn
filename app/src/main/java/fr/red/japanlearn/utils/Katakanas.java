package fr.red.japanlearn.utils;

import java.util.HashMap;
import java.util.Map;

public class Katakanas {

    public static HashMap<String, String> katakanaMap = new HashMap<>();
    public static HashMap<String, String> katakanaCombinedMap = new HashMap<>();

    static {
        // voyelles
        katakanaMap.put("ア", "a");
        katakanaMap.put("イ", "i");
        katakanaMap.put("ウ", "u");
        katakanaMap.put("エ", "e");
        katakanaMap.put("オ", "o");

        // k
        katakanaMap.put("カ", "ka");
        katakanaMap.put("キ", "ki");
        katakanaMap.put("ク", "ku");
        katakanaMap.put("ケ", "ke");
        katakanaMap.put("コ", "ko");

        // g
        katakanaMap.put("ガ", "ga");
        katakanaMap.put("ギ", "gi");
        katakanaMap.put("グ", "gu");
        katakanaMap.put("ゲ", "ge");
        katakanaMap.put("ゴ", "go");

        // s
        katakanaMap.put("サ", "sa");
        katakanaMap.put("シ", "shi");
        katakanaMap.put("ス", "su");
        katakanaMap.put("セ", "se");
        katakanaMap.put("ソ", "so");

        // z
        katakanaMap.put("ザ", "za");
        katakanaMap.put("ジ", "ji");
        katakanaMap.put("ズ", "zu");
        katakanaMap.put("ゼ", "ze");
        katakanaMap.put("ゾ", "zo");

        // t
        katakanaMap.put("タ", "ta");
        katakanaMap.put("チ", "chi");
        katakanaMap.put("ツ", "tsu");
        katakanaMap.put("テ", "te");
        katakanaMap.put("ト", "to");

        // d
        katakanaMap.put("ダ", "da");
        katakanaMap.put("ヂ", "ji");
        katakanaMap.put("ヅ", "zu");
        katakanaMap.put("デ", "de");
        katakanaMap.put("ド", "do");

        // n
        katakanaMap.put("ナ", "na");
        katakanaMap.put("ニ", "ni");
        katakanaMap.put("ヌ", "nu");
        katakanaMap.put("ネ", "ne");
        katakanaMap.put("ノ", "no");

        // h
        katakanaMap.put("ハ", "ha");
        katakanaMap.put("ヒ", "hi");
        katakanaMap.put("フ", "fu");
        katakanaMap.put("ヘ", "he");
        katakanaMap.put("ホ", "ho");

        // b
        katakanaMap.put("バ", "ba");
        katakanaMap.put("ビ", "bi");
        katakanaMap.put("ブ", "bu");
        katakanaMap.put("ベ", "be");
        katakanaMap.put("ボ", "bo");

        // p
        katakanaMap.put("パ", "pa");
        katakanaMap.put("ピ", "pi");
        katakanaMap.put("プ", "pu");
        katakanaMap.put("ペ", "pe");
        katakanaMap.put("ポ", "po");

        // m
        katakanaMap.put("マ", "ma");
        katakanaMap.put("ミ", "mi");
        katakanaMap.put("ム", "mu");
        katakanaMap.put("メ", "me");
        katakanaMap.put("モ", "mo");

        // y
        katakanaMap.put("ヤ", "ya");
        katakanaMap.put("ユ", "yu");
        katakanaMap.put("ヨ", "yo");

        // r
        katakanaMap.put("ラ", "ra");
        katakanaMap.put("リ", "ri");
        katakanaMap.put("ル", "ru");
        katakanaMap.put("レ", "re");
        katakanaMap.put("ロ", "ro");

        // w
        katakanaMap.put("ワ", "wa");
        katakanaMap.put("ヲ", "wo");

        // n
        katakanaMap.put("ン", "n");

        // petites lettres
        katakanaMap.put("ァ", "a");
        katakanaMap.put("ィ", "i");
        katakanaMap.put("ゥ", "u");
        katakanaMap.put("ェ", "e");
        katakanaMap.put("ォ", "o");
        katakanaMap.put("ャ", "ya");
        katakanaMap.put("ュ", "yu");
        katakanaMap.put("ョ", "yo");
    }

    static {
        // k+ya/yu/yo
        katakanaCombinedMap.put("キャ", "kya");
        katakanaCombinedMap.put("キュ", "kyu");
        katakanaCombinedMap.put("キョ", "kyo");

        // g+ya/yu/yo
        katakanaCombinedMap.put("ギャ", "gya");
        katakanaCombinedMap.put("ギュ", "gyu");
        katakanaCombinedMap.put("ギョ", "gyo");

        // s+ya/yu/yo
        katakanaCombinedMap.put("シャ", "sha");
        katakanaCombinedMap.put("シュ", "shu");
        katakanaCombinedMap.put("ショ", "sho");

        // z+ya/yu/yo
        katakanaCombinedMap.put("ジャ", "ja");
        katakanaCombinedMap.put("ジュ", "ju");
        katakanaCombinedMap.put("ジョ", "jo");

        // t+ya/yu/yo
        katakanaCombinedMap.put("チャ", "cha");
        katakanaCombinedMap.put("チュ", "chu");
        katakanaCombinedMap.put("チョ", "cho");

        // d+ya/yu/yo
        katakanaCombinedMap.put("ヂャ", "ja");
        katakanaCombinedMap.put("ヂュ", "ju");
        katakanaCombinedMap.put("ヂョ", "jo");

        // n+ya/yu/yo
        katakanaCombinedMap.put("ニャ", "nya");
        katakanaCombinedMap.put("ニュ", "nyu");
        katakanaCombinedMap.put("ニョ", "nyo");

        // h+ya/yu/yo
        katakanaCombinedMap.put("ヒャ", "hya");
        katakanaCombinedMap.put("ヒュ", "hyu");
        katakanaCombinedMap.put("ヒョ", "hyo");

        // b+ya/yu/yo
        katakanaCombinedMap.put("ビャ", "bya");
        katakanaCombinedMap.put("ビュ", "byu");
        katakanaCombinedMap.put("ビョ", "byo");

        // p+ya/yu/yo
        katakanaCombinedMap.put("ピャ", "pya");
        katakanaCombinedMap.put("ピュ", "pyu");
        katakanaCombinedMap.put("ピョ", "pyo");

        // m+ya/yu/yo
        katakanaCombinedMap.put("ミャ", "mya");
        katakanaCombinedMap.put("ミュ", "myu");
        katakanaCombinedMap.put("ミョ", "myo");

        // r+ya/yu/yo
        katakanaCombinedMap.put("リャ", "rya");
        katakanaCombinedMap.put("リュ", "ryu");
        katakanaCombinedMap.put("リョ", "ryo");
    }

    public static void addKatakanas(Map<String, String> currentSession, boolean addKatakana, boolean addComposition) {
        if (addKatakana) {
            currentSession.putAll(Katakanas.katakanaMap);
            if (addComposition) {
                currentSession.putAll(Katakanas.katakanaCombinedMap);
            }
        }
    }
}
