package fr.red.japanlearn.utils.chars;

import java.util.ArrayList;
import java.util.List;

import fr.red.japanlearn.utils.Question;

public class Kanji {

    public static List<Question> kanjiMap = new ArrayList<>();

    static {
        // Jours / Temps
        kanjiMap.add(new Question(CharOrigin.KANJI, "日", "nichi", "jour, soleil"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "月", "getsu", "lune, mois"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "火", "ka", "feu"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "水", "sui", "eau"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "木", "moku", "arbre"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "金", "kin", "or, argent (métal)"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "土", "do", "terre, sol"));

        // Nombres
        kanjiMap.add(new Question(CharOrigin.KANJI, "一", "ichi", "un"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "二", "ni", "deux"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "三", "san", "trois"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "四", "shi", "quatre"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "五", "go", "cinq"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "六", "roku", "six"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "七", "shichi", "sept"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "八", "hachi", "huit"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "九", "kyuu", "neuf"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "十", "juu", "dix"));

        // Personnes et relations
        kanjiMap.add(new Question(CharOrigin.KANJI, "人", "hito", "personne"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "女", "onna", "femme"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "男", "otoko", "homme"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "子", "ko", "enfant"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "友", "tomo", "ami"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "家族", "kazoku", "famille"));

        // Ecole et travail
        kanjiMap.add(new Question(CharOrigin.KANJI, "学", "gaku", "apprendre, étudier"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "校", "kou", "école"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "先生", "sensei", "professeur"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "生", "sei", "vie, naître"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "仕事", "shigoto", "travail"));

        // Lieux
        kanjiMap.add(new Question(CharOrigin.KANJI, "家", "ie", "maison"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "国", "kuni", "pays"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "町", "machi", "ville"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "山", "yama", "montagne"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "川", "kawa", "rivère"));

        // Corps humain
        kanjiMap.add(new Question(CharOrigin.KANJI, "目", "me", "oeil"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "口", "kuchi", "bouche"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "耳", "mimi", "oreille"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "手", "te", "main"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "足", "ashi", "jambe, pied"));

        // Nature
        kanjiMap.add(new Question(CharOrigin.KANJI, "花", "hana", "fleur"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "草", "kusa", "herbe"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "木", "ki", "arbre"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "石", "ishi", "pierre"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "空", "sora", "ciel"));

        // Directions
        kanjiMap.add(new Question(CharOrigin.KANJI, "上", "ue", "au-dessus"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "下", "shita", "en dessous"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "中", "naka", "dedans"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "外", "soto", "dehors"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "前", "mae", "avant"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "後", "ushiro", "après"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "左", "hidari", "gauche"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "右", "migi", "droite"));

        // Couleurs
        kanjiMap.add(new Question(CharOrigin.KANJI, "赤", "aka", "rouge"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "青", "ao", "bleu"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "白", "shiro", "blanc"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "黒", "kuro", "noir"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "黄色", "kiiro", "jaune"));

        // Transport
        kanjiMap.add(new Question(CharOrigin.KANJI, "電車", "densha", "train"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "自転車", "jitensha", "vélo"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "車", "kuruma", "voiture"));

        // Objets
        kanjiMap.add(new Question(CharOrigin.KANJI, "本", "hon", "livre"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "電話", "denwa", "téléphone"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "テレビ", "terebi", "télévision"));

        // Verbes très de base
        kanjiMap.add(new Question(CharOrigin.KANJI, "食べる", "taberu", "manger"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "飲む", "nomu", "boire"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "見る", "miru", "regarder"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "聞く", "kiku", "écouter"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "言う", "iu", "dire"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "行く", "iku", "aller"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "来る", "kuru", "venir"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "帰る", "kaeru", "rentrer"));

        // Temps / Saisons
        kanjiMap.add(new Question(CharOrigin.KANJI, "春", "haru", "printemps"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "夏", "natsu", "été"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "秋", "aki", "automne"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "冬", "fuyu", "hiver"));

        // Autres utiles
        kanjiMap.add(new Question(CharOrigin.KANJI, "安い", "yasui", "bon marché"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "高い", "takai", "cher, haut"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "大きい", "ookii", "grand"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "小さい", "chiisai", "petit"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "長い", "nagai", "long"));
        kanjiMap.add(new Question(CharOrigin.KANJI, "短い", "mijikai", "court"));
    }

    public static void addKanji(List<Question> currentSession, boolean addKanji) {
        if (addKanji) {
            currentSession.addAll(kanjiMap);
        }
    }

    public static List<Question> getMixUpQuestions(String wrongAnswer, boolean reversed) {
        List<Question> mixUpQuestions = new ArrayList<>();

        kanjiMap.stream().filter(question -> question.getAnswer(reversed).equals(wrongAnswer)).forEach(mixUpQuestions::add);

        return mixUpQuestions;
    }
}
