package ch.heigvd.amt.stackovergoat.infrastructure.persistence.memory;

import ch.heigvd.amt.stackovergoat.application.user.UsersQuery;
import ch.heigvd.amt.stackovergoat.domain.user.IUserRepository;
import ch.heigvd.amt.stackovergoat.domain.user.User;
import ch.heigvd.amt.stackovergoat.domain.user.UserId;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemoryUserRepository implements IUserRepository {

    private Map<UserId, User> store = new ConcurrentHashMap<>();

    @Override
    public void save(User user) {
        store.put(user.getId(), user);
    }

    @Override
    public void remove(UserId userId) {
        store.remove(userId);
    }

    @Override
    public Optional<User> findById(UserId userId) {
        User existingUser = store.get(userId);
        if (existingUser == null) {
            return Optional.empty();
        }
        User clonedUser = existingUser.toBuilder().build();
        return Optional.of(clonedUser);
    }

    @Override
    public Collection<User> findAll() {
        return store.values().stream()
                .map(user -> user.toBuilder().build())
                .collect(Collectors.toList());
    }

    @Override
    public Collection<User> find(UsersQuery query) {
        if(query != null && query.isUser()) {
            return findAll().stream()
                    .filter(user -> user.getUsername() != null)
                    .collect(Collectors.toList());
        }
        return findAll();
    }
}
