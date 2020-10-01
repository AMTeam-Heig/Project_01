package ch.heigvd.amt.stackovergoat.domain.answer;

import ch.heigvd.amt.stackovergoat.domain.IEntity;
import ch.heigvd.amt.stackovergoat.domain.question.QuestionId;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder(toBuilder = true)
public class Answer implements IEntity<Answer, AnswerId> {

    @Setter(AccessLevel.NONE)
    private AnswerId id;
    private QuestionId questionId;
    private String author;
    private String text;

    @Override
    public Answer deepClone() {
        return null;
    }

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
