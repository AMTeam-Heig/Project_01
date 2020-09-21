package ch.heigvd.amt.stackovergoat.model;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

@Getter @Setter
public class Question {
    private final int id;
    private final String title;
    private LinkedList<Integer> answers = new LinkedList<>();

    public Question(String title, int id) {
        this.id = id;
        this.title = title;
    }

    public void answer(int id) {
        answers.add(id);
    }
}
