package ch.heigvd.amt.stackovergoat.infrastructure.persistence.memory;

import ch.heigvd.amt.stackovergoat.application.question.QuestionsQuery;
import ch.heigvd.amt.stackovergoat.domain.question.IQuestionRepository;
import ch.heigvd.amt.stackovergoat.domain.question.Question;
import ch.heigvd.amt.stackovergoat.domain.question.QuestionId;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemoryQuestionRepository implements IQuestionRepository {

    private Map<QuestionId, Question> store = new ConcurrentHashMap<>();

    @Override
    public void save(Question question) {
        store.put(question.getId(), question);
    }

    @Override
    public void remove(QuestionId questionId) {
        store.remove(questionId);
    }

    @Override
    public Optional<Question> findById(QuestionId questionId) {
        Question existingQuestion = store.get(questionId);
        if (existingQuestion == null) {
            return Optional.empty();
        }
        Question clonedQuestion = existingQuestion.toBuilder().build();
        return Optional.of(clonedQuestion);
    }

    @Override
    public Collection<Question> findAll() {
        return store.values().stream()
                .map(question -> question.toBuilder().build())
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Question> find(QuestionsQuery query) {
        if(query != null && query.isQuestion()) {
            return findAll().stream()
                    .filter(question -> question.getAuthor() != null)
                    .collect(Collectors.toList());
        }
        return findAll();
    }
}
