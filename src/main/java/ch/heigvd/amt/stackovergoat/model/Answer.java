package ch.heigvd.amt.stackovergoat.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Answer {
    private final int id;
    private final String answer;

    public Answer(String answer, int id) {
        this.answer = answer;
        this.id = id;
    }
}
