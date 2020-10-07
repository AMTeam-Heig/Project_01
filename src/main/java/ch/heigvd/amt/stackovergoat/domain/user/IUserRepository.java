package ch.heigvd.amt.stackovergoat.domain.user;

import ch.heigvd.amt.stackovergoat.application.user.UsersQuery;
import ch.heigvd.amt.stackovergoat.domain.IRepository;
import ch.heigvd.amt.stackovergoat.infrastructure.persistence.memory.IntegrityConstraintViolationException;

import java.util.Collection;
import java.util.Optional;

public interface IUserRepository extends IRepository<User, UserId> {
    public Collection<User> find(UsersQuery query);
    public Optional<User> findByUsername(String username);
    public void save(User user) throws IntegrityConstraintViolationException;
}
