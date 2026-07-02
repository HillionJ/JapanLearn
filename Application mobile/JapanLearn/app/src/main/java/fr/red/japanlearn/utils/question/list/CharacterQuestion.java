package fr.red.japanlearn.utils.question.list;

import static fr.red.japanlearn.database.DataBase.listJoin;

import java.util.List;
import java.util.stream.Collectors;

import fr.red.japanlearn.utils.question.Question;

public class CharacterQuestion extends Question {

    public CharacterQuestion(int idQuestion, int idCharType, String character, String romaji, String explanation, boolean reversed, int score) {
        super(idQuestion, idCharType, character, romaji, explanation, reversed, score);
    }

    @Override
    public void updateSimilarity(List<Question> allQuestions) {
        String question = getQuestion();
        possibleAnswers.clear();
        possibleAnswers.add(getAnswer());

        List<Question> questionOfSameCategory = allQuestions.stream()
                .filter(q -> q.getIDCharType() == getIDCharType()) //Same category
                .filter(q -> !isSameObject(q))
                .collect(Collectors.toList());

        for (Question q: questionOfSameCategory) {
            if (question.equalsIgnoreCase(q.getQuestion(reversed))) {
                possibleAnswers.add(q.getAnswer(reversed));
            }
        }
    }

    @Override
    public boolean isValidAnswer(String answer) {
        return possibleAnswers.contains(answer);
    }

    @Override
    public boolean hasExplanation() {
        return getExplanation() != null;
    }

    @Override
    public String getExplanation() {
        if (explanation != null) {
            return explanation;
        }
        if (possibleAnswers.size() > 1) {
            return listJoin(possibleAnswers, ", ");
        }
        return null;
    }

    @Override
    public String getInfoTitle() {
        return explanation != null ? "Signification : " : "Réponses possible : ";
    }
}
