package fr.red.japanlearn.utils.question.list;

import android.util.Log;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import fr.red.japanlearn.utils.question.Question;

public class SelectQuestion extends Question {

    public SelectQuestion(int idQuestion, int idCharType, String character, String romaji, String explanation, boolean reversed) {
        super(idQuestion, idCharType, character, romaji, explanation, reversed);
    }

    @Override
    public void updateSimilarity(List<Question> allQuestions) {
        possibleAnswers.clear();
        possibleAnswers.add(getAnswer());

        List<Question> questionOfSameCategory = allQuestions.stream()
                .filter(q -> q.getIDCharType() == getIDCharType()) //Same category
                .filter(q -> !isSameObject(q))
                .collect(Collectors.toList());

        Collections.shuffle(questionOfSameCategory);
        questionOfSameCategory = questionOfSameCategory.subList(0, 2);
        for (Question q : questionOfSameCategory) {
            possibleAnswers.add(q.getAnswer(reversed));
        }
        Collections.shuffle(possibleAnswers);
    }

    @Override
    public boolean isValidAnswer(String answer) {
        return answer.equalsIgnoreCase(getAnswer());
    }
}
