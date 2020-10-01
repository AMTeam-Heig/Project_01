package ch.heigvd.amt.stackovergoat.infrastructure.persistence.memory;

import ch.heigvd.amt.stackovergoat.application.user.UsersQuery;
import ch.heigvd.amt.stackovergoat.domain.Id;
import ch.heigvd.amt.stackovergoat.domain.user.IUserRepository;
import ch.heigvd.amt.stackovergoat.domain.user.User;
import ch.heigvd.amt.stackovergoat.domain.user.UserId;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryUserRepository extends InMemoryRepository<User, UserId> implements IUserRepository {
    @Override
    public void save(User entity) {
        synchronized (entity.getUsername()) {
            if (!findByUsername(entity.getUsername()).isEmpty()) {
                //throw new IntegrityConstraintViolationException("Cannot save/update person...");
            }
            super.save(entity);
        }
    }

    @Override
    public Collection<User> find(UsersQuery query) {
        return null;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        List<User> matchingEntities = findAll().stream()
                .filter(u -> u.getUsername().equals(username))
                .collect(Collectors.toList());
        if(matchingEntities.size() < 1) {
            return Optional.empty();
        }

        if(matchingEntities.size() > 1) {
            //throw new DataCorruptionException("Your data store is corrupted...");
        }

        return Optional.of(matchingEntities.get(0).deepClone());
    }

}
