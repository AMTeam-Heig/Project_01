package ch.heigvd.amt.stackovergoat.business;

import ch.heigvd.amt.stackovergoat.model.Question;

import java.util.LinkedList;

public class QuestionManager {
    public LinkedList<Question> getQuestions() {
        LinkedList<Question> questions = new LinkedList<>();
        // TODO : get questions from file or database
        questions.add(new Question("What is GOAT?", 0));
        questions.add(new Question("Hello", 1));
        return questions;
    }
}