package ch.heigvd.amt.stackovergoat.domain.answer;

import ch.heigvd.amt.stackovergoat.domain.IEntity;
import ch.heigvd.amt.stackovergoat.domain.question.Question;
import ch.heigvd.amt.stackovergoat.domain.question.QuestionId;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder(toBuilder = true)
public class Answer implements IEntity {

    @Setter(AccessLevel.NONE)
    private AnswerId id = new AnswerId();

    private AnswerId questionId;

    private String author;

    private String text;

    public static class AnswerBuilder {
        public Answer build() {
            if(questionId == null) {
                // TODO throw exception
            }

            if(id == null) {
                id = new AnswerId();
            }

            if(text == null) {
                text = "";
            }

            return new Answer(id, questionId, author, text);
        }
    }
}