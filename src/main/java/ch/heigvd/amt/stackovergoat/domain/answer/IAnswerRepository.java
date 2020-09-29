package ch.heigvd.amt.stackovergoat.domain.answer;

import ch.heigvd.amt.stackovergoat.application.answer.AnswersQuery;
import ch.heigvd.amt.stackovergoat.domain.IRepository;

import java.util.Collection;

public interface IAnswerRepository extends IRepository<Answer, AnswerId> {
    public Collection<Answer> find(AnswersQuery query);
}
