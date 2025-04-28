package fr.red.japanlearn.utils;

import java.util.Map;

public enum Kanji {

    // Jours / Temps
    NICHI("日", "nichi", "jour, soleil"),
    GETSU("月", "getsu", "lune, mois"),
    KA("火", "ka", "feu"),
    SUI("水", "sui", "eau"),
    MOKU("木", "moku", "arbre"),
    KIN("金", "kin", "or, argent (métal)"),
    DO("土", "do", "terre, sol"),

    // Nombres
    ICHI("一", "ichi", "un"),
    NI("二", "ni", "deux"),
    SAN("三", "san", "trois"),
    SHI("四", "shi", "quatre"),
    GO("五", "go", "cinq"),
    ROKU("六", "roku", "six"),
    SHICHI("七", "shichi", "sept"),
    HACHI("八", "hachi", "huit"),
    KYUU("九", "kyuu", "neuf"),
    JUU("十", "juu", "dix"),

    // Personnes et relations
    HITO("人", "hito", "personne"),
    ONNA("女", "onna", "femme"),
    OTOKO("男", "otoko", "homme"),
    KO("子", "ko", "enfant"),
    TOMO("友", "tomo", "ami"),
    KAZOKU("家族", "kazoku", "famille"),

    // Ecole et travail
    GAKU("学", "gaku", "apprendre, étudier"),
    KOU("校", "kou", "école"),
    SENSEI("先生", "sensei", "professeur"),
    SEI("生", "sei", "vie, naître"),
    SHIGOTO("仕事", "shigoto", "travail"),

    // Lieux
    IE("家", "ie", "maison"),
    KUNI("国", "kuni", "pays"),
    MACHI("町", "machi", "ville"),
    YAMA("山", "yama", "montagne"),
    KAWA("川", "kawa", "rivère"),

    // Corps humain
    ME("目", "me", "oeil"),
    KUCHI("口", "kuchi", "bouche"),
    MIMI("耳", "mimi", "oreille"),
    TE("手", "te", "main"),
    ASHI("足", "ashi", "jambe, pied"),

    // Nature
    HANA("花", "hana", "fleur"),
    KUSA("草", "kusa", "herbe"),
    KI("木", "ki", "arbre"),
    ISHI("石", "ishi", "pierre"),
    SORA("空", "sora", "ciel"),

    // Directions
    UE("上", "ue", "au-dessus"),
    SHITA("下", "shita", "en dessous"),
    NAKA("中", "naka", "dedans"),
    SOTO("外", "soto", "dehors"),
    MAE("前", "mae", "avant"),
    USHIRO("後", "ushiro", "après"),
    HIDARI("左", "hidari", "gauche"),
    MIGI("右", "migi", "droite"),

    // Couleurs
    AKA("赤", "aka", "rouge"),
    AO("青", "ao", "bleu"),
    SHIRO("白", "shiro", "blanc"),
    KURO("黒", "kuro", "noir"),
    KI_IRO("黄色", "kiiro", "jaune"),

    // Transport
    DENSHA("電車", "densha", "train"),
    JIDENSHA("自転車", "jitensha", "vélo"),
    KURUMA("車", "kuruma", "voiture"),

    // Objets
    HON("本", "hon", "livre"),
    DENWA("電話", "denwa", "téléphone"),
    TEREBI("テレビ", "terebi", "télévision"),

    // Verbes très de base
    TABERU("食べる", "taberu", "manger"),
    NOMU("飲む", "nomu", "boire"),
    MIRU("見る", "miru", "regarder"),
    KIKU("聞く", "kiku", "écouter"),
    IU("言う", "iu", "dire"),
    IKU("行く", "iku", "aller"),
    KURU("来る", "kuru", "venir"),
    KAERU("帰る", "kaeru", "rentrer"),

    // Temps / Saisons
    HARU("春", "haru", "printemps"),
    NATSU("夏", "natsu", "été"),
    AKI("秋", "aki", "automne"),
    FUYU("冬", "fuyu", "hiver"),

    // Autres utiles
    YASUI("安い", "yasui", "bon marché"),
    TAKAI("高い", "takai", "cher, haut"),
    OOKII("大きい", "ookii", "grand"),
    CHIISAI("小さい", "chiisai", "petit"),
    NAGAI("長い", "nagai", "long"),
    MIJIKAI("短い", "mijikai", "court");


    private final String kanji;
    private final String romaji;
    private final String traductionFr;

    Kanji(String kanji, String romaji, String traductionFr) {
        this.kanji = kanji;
        this.romaji = romaji;
        this.traductionFr = traductionFr;
    }

    public String getKanji() {
        return kanji;
    }

    public String getRomaji() {
        return romaji;
    }

    public String getTraductionFr() {
        return traductionFr;
    }

    public static void addKanji(Map<String, String> currentSession, boolean addKanji) {
        if (addKanji) {
            for (Kanji kanji : values()) {
                currentSession.put(kanji.getKanji(), kanji.getRomaji());
            }
        }
    }
}
