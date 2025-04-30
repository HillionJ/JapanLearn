package fr.red.japanlearn.utils.chars;

import java.util.ArrayList;
import java.util.List;

import fr.red.japanlearn.utils.guess.GuessAnswerData;

public class Katakanas {

    public static List<GuessAnswerData> katakanaMap = new ArrayList<>();
    public static List<GuessAnswerData> katakanaCombinedMap = new ArrayList<>();

    static {
        // voyelles
        katakanaMap.add(new GuessAnswerData("ア", "a"));
        katakanaMap.add(new GuessAnswerData("イ", "i"));
        katakanaMap.add(new GuessAnswerData("ウ", "u"));
        katakanaMap.add(new GuessAnswerData("エ", "e"));
        katakanaMap.add(new GuessAnswerData("オ", "o"));

        // k
        katakanaMap.add(new GuessAnswerData("カ", "ka"));
        katakanaMap.add(new GuessAnswerData("キ", "ki"));
        katakanaMap.add(new GuessAnswerData("ク", "ku"));
        katakanaMap.add(new GuessAnswerData("ケ", "ke"));
        katakanaMap.add(new GuessAnswerData("コ", "ko"));

        // g
        katakanaMap.add(new GuessAnswerData("ガ", "ga"));
        katakanaMap.add(new GuessAnswerData("ギ", "gi"));
        katakanaMap.add(new GuessAnswerData("グ", "gu"));
        katakanaMap.add(new GuessAnswerData("ゲ", "ge"));
        katakanaMap.add(new GuessAnswerData("ゴ", "go"));

        // s
        katakanaMap.add(new GuessAnswerData("サ", "sa"));
        katakanaMap.add(new GuessAnswerData("シ", "shi"));
        katakanaMap.add(new GuessAnswerData("ス", "su"));
        katakanaMap.add(new GuessAnswerData("セ", "se"));
        katakanaMap.add(new GuessAnswerData("ソ", "so"));

        // z
        katakanaMap.add(new GuessAnswerData("ザ", "za"));
        katakanaMap.add(new GuessAnswerData("ジ", "ji"));
        katakanaMap.add(new GuessAnswerData("ズ", "zu"));
        katakanaMap.add(new GuessAnswerData("ゼ", "ze"));
        katakanaMap.add(new GuessAnswerData("ゾ", "zo"));

        // t
        katakanaMap.add(new GuessAnswerData("タ", "ta"));
        katakanaMap.add(new GuessAnswerData("チ", "chi"));
        katakanaMap.add(new GuessAnswerData("ツ", "tsu"));
        katakanaMap.add(new GuessAnswerData("テ", "te"));
        katakanaMap.add(new GuessAnswerData("ト", "to"));

        // d
        katakanaMap.add(new GuessAnswerData("ダ", "da"));
        katakanaMap.add(new GuessAnswerData("ヂ", "ji"));
        katakanaMap.add(new GuessAnswerData("ヅ", "zu"));
        katakanaMap.add(new GuessAnswerData("デ", "de"));
        katakanaMap.add(new GuessAnswerData("ド", "do"));

        // n
        katakanaMap.add(new GuessAnswerData("ナ", "na"));
        katakanaMap.add(new GuessAnswerData("ニ", "ni"));
        katakanaMap.add(new GuessAnswerData("ヌ", "nu"));
        katakanaMap.add(new GuessAnswerData("ネ", "ne"));
        katakanaMap.add(new GuessAnswerData("ノ", "no"));

        // h
        katakanaMap.add(new GuessAnswerData("ハ", "ha"));
        katakanaMap.add(new GuessAnswerData("ヒ", "hi"));
        katakanaMap.add(new GuessAnswerData("フ", "fu"));
        katakanaMap.add(new GuessAnswerData("ヘ", "he"));
        katakanaMap.add(new GuessAnswerData("ホ", "ho"));

        // b
        katakanaMap.add(new GuessAnswerData("バ", "ba"));
        katakanaMap.add(new GuessAnswerData("ビ", "bi"));
        katakanaMap.add(new GuessAnswerData("ブ", "bu"));
        katakanaMap.add(new GuessAnswerData("ベ", "be"));
        katakanaMap.add(new GuessAnswerData("ボ", "bo"));

        // p
        katakanaMap.add(new GuessAnswerData("パ", "pa"));
        katakanaMap.add(new GuessAnswerData("ピ", "pi"));
        katakanaMap.add(new GuessAnswerData("プ", "pu"));
        katakanaMap.add(new GuessAnswerData("ペ", "pe"));
        katakanaMap.add(new GuessAnswerData("ポ", "po"));

        // m
        katakanaMap.add(new GuessAnswerData("マ", "ma"));
        katakanaMap.add(new GuessAnswerData("ミ", "mi"));
        katakanaMap.add(new GuessAnswerData("ム", "mu"));
        katakanaMap.add(new GuessAnswerData("メ", "me"));
        katakanaMap.add(new GuessAnswerData("モ", "mo"));

        // y
        katakanaMap.add(new GuessAnswerData("ヤ", "ya"));
        katakanaMap.add(new GuessAnswerData("ユ", "yu"));
        katakanaMap.add(new GuessAnswerData("ヨ", "yo"));

        // r
        katakanaMap.add(new GuessAnswerData("ラ", "ra"));
        katakanaMap.add(new GuessAnswerData("リ", "ri"));
        katakanaMap.add(new GuessAnswerData("ル", "ru"));
        katakanaMap.add(new GuessAnswerData("レ", "re"));
        katakanaMap.add(new GuessAnswerData("ロ", "ro"));

        // w
        katakanaMap.add(new GuessAnswerData("ワ", "wa"));
        katakanaMap.add(new GuessAnswerData("ヲ", "wo"));

        // n
        katakanaMap.add(new GuessAnswerData("ン", "n"));

        // petites lettres
        katakanaMap.add(new GuessAnswerData("ァ", "a"));
        katakanaMap.add(new GuessAnswerData("ィ", "i"));
        katakanaMap.add(new GuessAnswerData("ゥ", "u"));
        katakanaMap.add(new GuessAnswerData("ェ", "e"));
        katakanaMap.add(new GuessAnswerData("ォ", "o"));
        katakanaMap.add(new GuessAnswerData("ャ", "ya"));
        katakanaMap.add(new GuessAnswerData("ュ", "yu"));
        katakanaMap.add(new GuessAnswerData("ョ", "yo"));
    }

    static {
        // k+ya/yu/yo
        katakanaCombinedMap.add(new GuessAnswerData("キャ", "kya"));
        katakanaCombinedMap.add(new GuessAnswerData("キュ", "kyu"));
        katakanaCombinedMap.add(new GuessAnswerData("キョ", "kyo"));

        // g+ya/yu/yo
        katakanaCombinedMap.add(new GuessAnswerData("ギャ", "gya"));
        katakanaCombinedMap.add(new GuessAnswerData("ギュ", "gyu"));
        katakanaCombinedMap.add(new GuessAnswerData("ギョ", "gyo"));

        // s+ya/yu/yo
        katakanaCombinedMap.add(new GuessAnswerData("シャ", "sha"));
        katakanaCombinedMap.add(new GuessAnswerData("シュ", "shu"));
        katakanaCombinedMap.add(new GuessAnswerData("ショ", "sho"));

        // z+ya/yu/yo
        katakanaCombinedMap.add(new GuessAnswerData("ジャ", "ja"));
        katakanaCombinedMap.add(new GuessAnswerData("ジュ", "ju"));
        katakanaCombinedMap.add(new GuessAnswerData("ジョ", "jo"));

        // t+ya/yu/yo
        katakanaCombinedMap.add(new GuessAnswerData("チャ", "cha"));
        katakanaCombinedMap.add(new GuessAnswerData("チュ", "chu"));
        katakanaCombinedMap.add(new GuessAnswerData("チョ", "cho"));

        // d+ya/yu/yo
        katakanaCombinedMap.add(new GuessAnswerData("ヂャ", "ja"));
        katakanaCombinedMap.add(new GuessAnswerData("ヂュ", "ju"));
        katakanaCombinedMap.add(new GuessAnswerData("ヂョ", "jo"));

        // n+ya/yu/yo
        katakanaCombinedMap.add(new GuessAnswerData("ニャ", "nya"));
        katakanaCombinedMap.add(new GuessAnswerData("ニュ", "nyu"));
        katakanaCombinedMap.add(new GuessAnswerData("ニョ", "nyo"));

        // h+ya/yu/yo
        katakanaCombinedMap.add(new GuessAnswerData("ヒャ", "hya"));
        katakanaCombinedMap.add(new GuessAnswerData("ヒュ", "hyu"));
        katakanaCombinedMap.add(new GuessAnswerData("ヒョ", "hyo"));

        // b+ya/yu/yo
        katakanaCombinedMap.add(new GuessAnswerData("ビャ", "bya"));
        katakanaCombinedMap.add(new GuessAnswerData("ビュ", "byu"));
        katakanaCombinedMap.add(new GuessAnswerData("ビョ", "byo"));

        // p+ya/yu/yo
        katakanaCombinedMap.add(new GuessAnswerData("ピャ", "pya"));
        katakanaCombinedMap.add(new GuessAnswerData("ピュ", "pyu"));
        katakanaCombinedMap.add(new GuessAnswerData("ピョ", "pyo"));

        // m+ya/yu/yo
        katakanaCombinedMap.add(new GuessAnswerData("ミャ", "mya"));
        katakanaCombinedMap.add(new GuessAnswerData("ミュ", "myu"));
        katakanaCombinedMap.add(new GuessAnswerData("ミョ", "myo"));

        // r+ya/yu/yo
        katakanaCombinedMap.add(new GuessAnswerData("リャ", "rya"));
        katakanaCombinedMap.add(new GuessAnswerData("リュ", "ryu"));
        katakanaCombinedMap.add(new GuessAnswerData("リョ", "ryo"));
    }

    public static void addKatakanas(List<GuessAnswerData> currentSession, boolean addKatakana, boolean addComposition) {
        if (addKatakana) {
            currentSession.addAll(Katakanas.katakanaMap);
            if (addComposition) {
                currentSession.addAll(Katakanas.katakanaCombinedMap);
            }
        }
    }
}
