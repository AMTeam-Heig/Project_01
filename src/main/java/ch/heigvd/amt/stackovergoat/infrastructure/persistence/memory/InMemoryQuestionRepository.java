package ch.heigvd.amt.stackovergoat.infrastructure.persistence.memory;
import ch.heigvd.amt.stackovergoat.application.question.QuestionsQuery;
import ch.heigvd.amt.stackovergoat.domain.question.IQuestionRepository;
import ch.heigvd.amt.stackovergoat.domain.question.Question;
import ch.heigvd.amt.stackovergoat.domain.question.QuestionId;

import java.util.Collection;
import java.util.stream.Collectors;

public class InMemoryQuestionRepository extends InMemoryRepository<Question, QuestionId> implements IQuestionRepository {
    @Override
    public Collection<Question> find(QuestionsQuery query) {
        if(query != null) {
            return findAll().stream()
                    .collect(Collectors.toList());
        }
        return findAll();
    }

}