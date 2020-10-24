package ch.heigvd.amt.stackovergoat.application.comment;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@Builder
@Getter
@EqualsAndHashCode
public class CommentsQuery {

    @Builder.Default
    private boolean commentsAnswer = true;

    @Builder.Default
    private String idAnswer = "";

    @Builder.Default
    private String idQuestion = "";

    @Builder.Default
    private String author = "";

    @Builder.Default
    private String comment = "";
}
