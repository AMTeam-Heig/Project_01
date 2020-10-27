package ch.heigvd.amt.stackovergoat.infrastructure.persistence.jdbc;

import ch.heigvd.amt.stackovergoat.application.vote.VotesQuery;
import ch.heigvd.amt.stackovergoat.domain.vote.IVoteRepository;
import ch.heigvd.amt.stackovergoat.domain.vote.Vote;
import ch.heigvd.amt.stackovergoat.domain.vote.VoteId;
import ch.heigvd.amt.stackovergoat.infrastructure.persistence.exception.IntegrityConstraintViolationException;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.sql.DataSource;
import java.util.Collection;
import java.util.Optional;

@ApplicationScoped
@Named("JdbcVoteRepository")
public class JdbcVoteRepository implements IVoteRepository {

    @Resource(lookup = "jdbc/StackOverflowDS")
    DataSource dataSource;

    @Override
    public Collection<Vote> find(VotesQuery query) {
        return null;
    }

    @Override
    public void save(Vote entity) throws IntegrityConstraintViolationException {

    }

    @Override
    public void remove(VoteId id) {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public Optional<Vote> findById(VoteId voteId) {
        return Optional.empty();
    }

    @Override
    public Collection<Vote> findAll() {
        return null;
    }
}
