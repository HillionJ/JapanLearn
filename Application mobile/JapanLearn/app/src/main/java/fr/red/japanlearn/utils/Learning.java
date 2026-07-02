package fr.red.japanlearn.utils;

import fr.red.japanlearn.database.DataBase;
import fr.red.japanlearn.utils.question.Question;

public class Learning {

    private static Learning instance;

    public static Learning getLearning() {
        if (instance == null)
            instance = new Learning();
        return instance;
    }

    private final DataBase dataBase;

    public Learning() {
        dataBase = DataBase.getDataBase();
    }

    public void updateScore(Question question, int increment) {
        dataBase.updateLearningScore(question, increment);
    }
}
