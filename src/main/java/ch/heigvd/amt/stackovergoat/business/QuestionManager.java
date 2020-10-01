package ch.heigvd.amt.stackovergoat.business;

import ch.heigvd.amt.stackovergoat.model.Question;
import lombok.Getter;

import java.util.LinkedList;

@Getter
public class QuestionManager {
    private LinkedList<Question> questions = new LinkedList<>();

    public QuestionManager() {
        questions.add(new Question("What is GOAT?", 0, 1));
        questions.add(new Question("Who is this?", 1, 2));
        questions.add(new Question("To be or not to be?", 2, 3));
        questions.add(new Question("To beer or not to beer?", 3, 4));
        questions.add(new Question("What is 42?", 4, 4));
        questions.add(new Question("Why?", 5, 4));
        questions.add(new Question("Who is CosmicDarine?", 6, 1));
    }

    public Question getQuestion(int id) {
        for (Question q :
                questions) {
            if (q.getId() == id) {
                return q;
            }
        }
        return null;
    }
}
