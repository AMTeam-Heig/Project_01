package ch.heigvd.amt.stackovergoat.application.question;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.LinkedList;


@Builder
@Getter
@EqualsAndHashCode
public class QuestionsQuery {

    @Builder.Default
    private boolean isQuestion = true;

    @Builder.Default
    private String idQuestion = "";

    @Builder.Default
    private String author = "";

    @Builder.Default
    private String text = "";

    @Builder.Default
    private LinkedList<String> words = new LinkedList<>();

}
