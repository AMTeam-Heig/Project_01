package ch.heigvd.amt.stackovergoat.application.question;

import ch.heigvd.amt.stackovergoat.application.answer.AnswersDTO;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Singular;

import java.util.List;

@Builder
@Getter
@EqualsAndHashCode
public class QuestionsDTO {

    @Builder
    @Getter
    @EqualsAndHashCode
    public static class QuestionDTO {
        private String id;
        private String text;
        private String author;
    }

    @Singular
    private List<QuestionDTO> questions;
}
