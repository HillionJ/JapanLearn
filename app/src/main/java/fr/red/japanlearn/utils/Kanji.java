package fr.red.japanlearn.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Kanji {

    public static List<GuessAnswerData> kanjiMap = new ArrayList<>();

    static {
        // Jours / Temps
        kanjiMap.add(new GuessAnswerData("日", "nichi", "jour, soleil"));
        kanjiMap.add(new GuessAnswerData("月", "getsu", "lune, mois"));
        kanjiMap.add(new GuessAnswerData("火", "ka", "feu"));
        kanjiMap.add(new GuessAnswerData("水", "sui", "eau"));
        kanjiMap.add(new GuessAnswerData("木", "moku", "arbre"));
        kanjiMap.add(new GuessAnswerData("金", "kin", "or, argent (métal)"));
        kanjiMap.add(new GuessAnswerData("土", "do", "terre, sol"));

        // Nombres
        kanjiMap.add(new GuessAnswerData("一", "ichi", "un"));
        kanjiMap.add(new GuessAnswerData("二", "ni", "deux"));
        kanjiMap.add(new GuessAnswerData("三", "san", "trois"));
        kanjiMap.add(new GuessAnswerData("四", "shi", "quatre"));
        kanjiMap.add(new GuessAnswerData("五", "go", "cinq"));
        kanjiMap.add(new GuessAnswerData("六", "roku", "six"));
        kanjiMap.add(new GuessAnswerData("七", "shichi", "sept"));
        kanjiMap.add(new GuessAnswerData("八", "hachi", "huit"));
        kanjiMap.add(new GuessAnswerData("九", "kyuu", "neuf"));
        kanjiMap.add(new GuessAnswerData("十", "juu", "dix"));

        // Personnes et relations
        kanjiMap.add(new GuessAnswerData("人", "hito", "personne"));
        kanjiMap.add(new GuessAnswerData("女", "onna", "femme"));
        kanjiMap.add(new GuessAnswerData("男", "otoko", "homme"));
        kanjiMap.add(new GuessAnswerData("子", "ko", "enfant"));
        kanjiMap.add(new GuessAnswerData("友", "tomo", "ami"));
        kanjiMap.add(new GuessAnswerData("家族", "kazoku", "famille"));

        // Ecole et travail
        kanjiMap.add(new GuessAnswerData("学", "gaku", "apprendre, étudier"));
        kanjiMap.add(new GuessAnswerData("校", "kou", "école"));
        kanjiMap.add(new GuessAnswerData("先生", "sensei", "professeur"));
        kanjiMap.add(new GuessAnswerData("生", "sei", "vie, naître"));
        kanjiMap.add(new GuessAnswerData("仕事", "shigoto", "travail"));

        // Lieux
        kanjiMap.add(new GuessAnswerData("家", "ie", "maison"));
        kanjiMap.add(new GuessAnswerData("国", "kuni", "pays"));
        kanjiMap.add(new GuessAnswerData("町", "machi", "ville"));
        kanjiMap.add(new GuessAnswerData("山", "yama", "montagne"));
        kanjiMap.add(new GuessAnswerData("川", "kawa", "rivère"));

        // Corps humain
        kanjiMap.add(new GuessAnswerData("目", "me", "oeil"));
        kanjiMap.add(new GuessAnswerData("口", "kuchi", "bouche"));
        kanjiMap.add(new GuessAnswerData("耳", "mimi", "oreille"));
        kanjiMap.add(new GuessAnswerData("手", "te", "main"));
        kanjiMap.add(new GuessAnswerData("足", "ashi", "jambe, pied"));

        // Nature
        kanjiMap.add(new GuessAnswerData("花", "hana", "fleur"));
        kanjiMap.add(new GuessAnswerData("草", "kusa", "herbe"));
        kanjiMap.add(new GuessAnswerData("木", "ki", "arbre"));
        kanjiMap.add(new GuessAnswerData("石", "ishi", "pierre"));
        kanjiMap.add(new GuessAnswerData("空", "sora", "ciel"));

        // Directions
        kanjiMap.add(new GuessAnswerData("上", "ue", "au-dessus"));
        kanjiMap.add(new GuessAnswerData("下", "shita", "en dessous"));
        kanjiMap.add(new GuessAnswerData("中", "naka", "dedans"));
        kanjiMap.add(new GuessAnswerData("外", "soto", "dehors"));
        kanjiMap.add(new GuessAnswerData("前", "mae", "avant"));
        kanjiMap.add(new GuessAnswerData("後", "ushiro", "après"));
        kanjiMap.add(new GuessAnswerData("左", "hidari", "gauche"));
        kanjiMap.add(new GuessAnswerData("右", "migi", "droite"));

        // Couleurs
        kanjiMap.add(new GuessAnswerData("赤", "aka", "rouge"));
        kanjiMap.add(new GuessAnswerData("青", "ao", "bleu"));
        kanjiMap.add(new GuessAnswerData("白", "shiro", "blanc"));
        kanjiMap.add(new GuessAnswerData("黒", "kuro", "noir"));
        kanjiMap.add(new GuessAnswerData("黄色", "kiiro", "jaune"));

        // Transport
        kanjiMap.add(new GuessAnswerData("電車", "densha", "train"));
        kanjiMap.add(new GuessAnswerData("自転車", "jitensha", "vélo"));
        kanjiMap.add(new GuessAnswerData("車", "kuruma", "voiture"));

        // Objets
        kanjiMap.add(new GuessAnswerData("本", "hon", "livre"));
        kanjiMap.add(new GuessAnswerData("電話", "denwa", "téléphone"));
        kanjiMap.add(new GuessAnswerData("テレビ", "terebi", "télévision"));

        // Verbes très de base
        kanjiMap.add(new GuessAnswerData("食べる", "taberu", "manger"));
        kanjiMap.add(new GuessAnswerData("飲む", "nomu", "boire"));
        kanjiMap.add(new GuessAnswerData("見る", "miru", "regarder"));
        kanjiMap.add(new GuessAnswerData("聞く", "kiku", "écouter"));
        kanjiMap.add(new GuessAnswerData("言う", "iu", "dire"));
        kanjiMap.add(new GuessAnswerData("行く", "iku", "aller"));
        kanjiMap.add(new GuessAnswerData("来る", "kuru", "venir"));
        kanjiMap.add(new GuessAnswerData("帰る", "kaeru", "rentrer"));

        // Temps / Saisons
        kanjiMap.add(new GuessAnswerData("春", "haru", "printemps"));
        kanjiMap.add(new GuessAnswerData("夏", "natsu", "été"));
        kanjiMap.add(new GuessAnswerData("秋", "aki", "automne"));
        kanjiMap.add(new GuessAnswerData("冬", "fuyu", "hiver"));

        // Autres utiles
        kanjiMap.add(new GuessAnswerData("安い", "yasui", "bon marché"));
        kanjiMap.add(new GuessAnswerData("高い", "takai", "cher, haut"));
        kanjiMap.add(new GuessAnswerData("大きい", "ookii", "grand"));
        kanjiMap.add(new GuessAnswerData("小さい", "chiisai", "petit"));
        kanjiMap.add(new GuessAnswerData("長い", "nagai", "long"));
        kanjiMap.add(new GuessAnswerData("短い", "mijikai", "court"));
    }

    public static void addKanji(List<GuessAnswerData> currentSession, boolean addKanji) {
        if (addKanji) {
            currentSession.addAll(kanjiMap);
        }
    }
}
