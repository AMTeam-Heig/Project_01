package ch.heigvd.amt.stackovergoat.application.comment;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Singular;

import java.util.List;

@Builder
@Getter
@EqualsAndHashCode
public class CommentsDTO {

    @Builder
    @Getter
    @EqualsAndHashCode
    public static class CommentDTO {
        private String idQuestion;
        private String idAnswer;
        private String comment;
        private String author;
    }

    @Singular
    private List<CommentDTO> comments;
}
