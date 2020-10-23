package ch.heigvd.amt.stackovergoat.domain.question;

import ch.heigvd.amt.stackovergoat.domain.IEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder(toBuilder = true)
public class Question implements IEntity<Question, QuestionId> {

    private QuestionId id;

    private String author;

    private String text;

    @Override
    public Question deepClone() {
        return this.toBuilder()
                .id(new QuestionId(id.asString()))
                .build();
    }

    public boolean containsWord(String word) {
        return text.contains(word) || author.equals(word);
    }

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
