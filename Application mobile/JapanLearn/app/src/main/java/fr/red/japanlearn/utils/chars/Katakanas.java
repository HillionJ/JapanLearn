package fr.red.japanlearn.utils.chars;

import java.util.ArrayList;
import java.util.List;

import fr.red.japanlearn.utils.Question;

public class Katakanas {

    public static List<Question> katakanaMap = new ArrayList<>();
    public static List<Question> katakanaCombinedMap = new ArrayList<>();

    static {
        // voyelles
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ア", "a"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "イ", "i"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ウ", "u"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "エ", "e"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "オ", "o"));

        // k
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "カ", "ka"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "キ", "ki"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ク", "ku"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ケ", "ke"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "コ", "ko"));

        // g
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ガ", "ga"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ギ", "gi"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "グ", "gu"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ゲ", "ge"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ゴ", "go"));

        // s
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "サ", "sa"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "シ", "shi"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ス", "su"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "セ", "se"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ソ", "so"));

        // z
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ザ", "za"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ジ", "ji"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ズ", "zu"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ゼ", "ze"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ゾ", "zo"));

        // t
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "タ", "ta"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "チ", "chi"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ツ", "tsu"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "テ", "te"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ト", "to"));

        // d
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ダ", "da"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ヂ", "ji"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ヅ", "zu"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "デ", "de"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ド", "do"));

        // n
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ナ", "na"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ニ", "ni"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ヌ", "nu"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ネ", "ne"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ノ", "no"));

        // h
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ハ", "ha"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ヒ", "hi"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "フ", "fu"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ヘ", "he"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ホ", "ho"));

        // b
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "バ", "ba"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ビ", "bi"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ブ", "bu"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ベ", "be"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ボ", "bo"));

        // p
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "パ", "pa"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ピ", "pi"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "プ", "pu"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ペ", "pe"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ポ", "po"));

        // m
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "マ", "ma"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ミ", "mi"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ム", "mu"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "メ", "me"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "モ", "mo"));

        // y
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ヤ", "ya"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ユ", "yu"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ヨ", "yo"));

        // r
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ラ", "ra"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "リ", "ri"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ル", "ru"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "レ", "re"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ロ", "ro"));

        // w
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ワ", "wa"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ヲ", "wo"));

        // n
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ン", "n"));

        // petites lettres
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ァ", "a"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ィ", "i"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ゥ", "u"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ェ", "e"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ォ", "o"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ャ", "ya"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ュ", "yu"));
        katakanaMap.add(new Question(CharOrigin.KATAKANA, "ョ", "yo"));
    }

    static {
        // k+ya/yu/yo
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "キャ", "kya"));
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "キュ", "kyu"));
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "キョ", "kyo"));

        // g+ya/yu/yo
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "ギャ", "gya"));
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "ギュ", "gyu"));
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "ギョ", "gyo"));

        // s+ya/yu/yo
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "シャ", "sha"));
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "シュ", "shu"));
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "ショ", "sho"));

        // z+ya/yu/yo
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "ジャ", "ja"));
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "ジュ", "ju"));
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "ジョ", "jo"));

        // t+ya/yu/yo
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "チャ", "cha"));
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "チュ", "chu"));
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "チョ", "cho"));

        // d+ya/yu/yo
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "ヂャ", "ja"));
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "ヂュ", "ju"));
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "ヂョ", "jo"));

        // n+ya/yu/yo
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "ニャ", "nya"));
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "ニュ", "nyu"));
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "ニョ", "nyo"));

        // h+ya/yu/yo
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "ヒャ", "hya"));
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "ヒュ", "hyu"));
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "ヒョ", "hyo"));

        // b+ya/yu/yo
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "ビャ", "bya"));
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "ビュ", "byu"));
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "ビョ", "byo"));

        // p+ya/yu/yo
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "ピャ", "pya"));
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "ピュ", "pyu"));
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "ピョ", "pyo"));

        // m+ya/yu/yo
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "ミャ", "mya"));
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "ミュ", "myu"));
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "ミョ", "myo"));

        // r+ya/yu/yo
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "リャ", "rya"));
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "リュ", "ryu"));
        katakanaCombinedMap.add(new Question(CharOrigin.KATAKANA, "リョ", "ryo"));
    }

    public static void addKatakanas(List<Question> currentSession, boolean addKatakana, boolean addComposition) {
        if (addKatakana) {
            currentSession.addAll(Katakanas.katakanaMap);
            if (addComposition) {
                currentSession.addAll(Katakanas.katakanaCombinedMap);
            }
        }
    }

    public static List<Question> getMixUpQuestions(String wrongAnswer, boolean reversed) {
        List<Question> mixUpQuestions = new ArrayList<>();

        katakanaMap.stream().map(question -> question.getGuess(reversed)).filter(string -> string.equals(wrongAnswer)).forEach(guess -> {
            mixUpQuestions.add(new Question(CharOrigin.HIRAGANA, guess, wrongAnswer));
        });
        katakanaCombinedMap.stream().map(question -> question.getGuess(reversed)).filter(string -> string.equals(wrongAnswer)).forEach(guess -> {
            mixUpQuestions.add(new Question(CharOrigin.HIRAGANA, guess, wrongAnswer));
        });

        return mixUpQuestions;
    }
}
