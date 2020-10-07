package ch.heigvd.amt.stackovergoat.infrastructure.persistence.jdbc;

import ch.heigvd.amt.stackovergoat.application.question.QuestionsQuery;
import ch.heigvd.amt.stackovergoat.domain.question.IQuestionRepository;
import ch.heigvd.amt.stackovergoat.domain.question.Question;
import ch.heigvd.amt.stackovergoat.domain.question.QuestionId;

import java.util.Collection;
import java.util.Optional;

public class JdbcQQuestionRepository  implements IQuestionRepository {
    @Override
    public Collection<Question> find(QuestionsQuery query) {
        return null;
    }

    @Override
    public Collection<Question> findAll() {
        return null;
    }

    @Override
    public void save(Question entity) {

    }

    @Override
    public void remove(QuestionId id) {

    }

    @Override
    public Optional<Question> findById(QuestionId question) {
        return Optional.empty();
    }
}
