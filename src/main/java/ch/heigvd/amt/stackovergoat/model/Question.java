package ch.heigvd.amt.stackovergoat.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Question {
    private final int id;
    private final int authorId;
    private final String title;

    public Question(String title, int id, int authorId) {
        this.id = id;
        this.authorId = authorId;
        this.title = title;
    }
}
