package ch.heigvd.amt.stackovergoat.model;

import lombok.Getter;

@Getter
public class Answer {
    private final int id;
    private final int questionId;
    private final int authorId;
    private final String answer;

    public Answer(String answer, int id, int questionId, int authorId) {
        this.answer = answer;
        this.id = id;
        this.questionId = questionId;
        this.authorId = authorId;
    }
}
