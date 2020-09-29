package ch.heigvd.amt.stackovergoat.infrastructure.persistence.memory;

import ch.heigvd.amt.stackovergoat.application.answer.AnswersQuery;
import ch.heigvd.amt.stackovergoat.domain.answer.IAnswerRepository;
import ch.heigvd.amt.stackovergoat.domain.answer.Answer;
import ch.heigvd.amt.stackovergoat.domain.answer.AnswerId;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemoryAnswerRepository implements IAnswerRepository {

    private Map<AnswerId, Answer> store = new ConcurrentHashMap<>();

    @Override
    public void save(Answer answer) {
        store.put(answer.getId(), answer);
    }

    @Override
    public void remove(AnswerId answerId) {
        store.remove(answerId);
    }

    @Override
    public Optional<Answer> findById(AnswerId answerId) {
        Answer existingAnswer = store.get(answerId);
        if (existingAnswer == null) {
            return Optional.empty();
        }
        Answer clonedAnswer = existingAnswer.toBuilder().build();
        return Optional.of(clonedAnswer);
    }

    @Override
    public Collection<Answer> findAll() {
        return store.values().stream()
                .map(answer -> answer.toBuilder().build())
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Answer> find(AnswersQuery query) {
        if(query != null && query.isAnswer()) {
            return findAll().stream()
                    .filter(answer -> answer.getAuthor() != null)
                    .collect(Collectors.toList());
        }
        return findAll();
    }
}
