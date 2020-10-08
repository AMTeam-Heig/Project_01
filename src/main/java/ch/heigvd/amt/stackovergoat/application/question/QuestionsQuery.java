package ch.heigvd.amt.stackovergoat.application.question;

import ch.heigvd.amt.stackovergoat.domain.question.QuestionId;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@Builder
@Getter
@EqualsAndHashCode
public class QuestionsQuery {

    @Builder.Default
    private boolean isQuestion = true;

    @Builder.Default
    private QuestionId id = null;
}
