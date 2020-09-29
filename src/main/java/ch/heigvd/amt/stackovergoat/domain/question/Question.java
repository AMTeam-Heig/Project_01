package ch.heigvd.amt.stackovergoat.domain.question;

import ch.heigvd.amt.stackovergoat.domain.IEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder(toBuilder = true)
public class Question implements IEntity {

    @Setter(AccessLevel.NONE)
    private QuestionId id = new QuestionId();

    private String author;

    private String text;

    public static class QuestionBuilder {
        public Question build() {
            if(id == null) {
                id = new QuestionId();
            }

            if(text == null) {
                text = "";
            }

            return new Question(id, author, text);
        }
    }
}
