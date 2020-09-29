package ch.heigvd.amt.stackovergoat.application.answer;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@Builder
@Getter
@EqualsAndHashCode
public class AnswersQuery {

    @Builder.Default
    private boolean isAnswer = true;
}
