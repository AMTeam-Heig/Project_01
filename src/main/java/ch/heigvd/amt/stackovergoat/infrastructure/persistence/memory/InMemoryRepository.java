package ch.heigvd.amt.stackovergoat.infrastructure.persistence.memory;

import ch.heigvd.amt.stackovergoat.domain.IEntity;
import ch.heigvd.amt.stackovergoat.domain.IRepository;
import ch.heigvd.amt.stackovergoat.domain.Id;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemoryRepository<ENTITY extends IEntity<ENTITY, ID>, ID extends Id> implements IRepository<ENTITY, ID> {
    private Map<ID, ENTITY> store = new ConcurrentHashMap<>();

    public void save(ENTITY entity) {
        if(entity.getId() == null) {
            System.out.println("Error : Id should not be null");
        } else {
          store.put(entity.getId(), entity);
        }
    }

    public void remove(ID id) {
        store.remove(id);
    }

    public Optional<ENTITY> findById(ID id) {
        ENTITY existingEntity = store.get(id);
        if(existingEntity == null) {
            return Optional.empty();
        }
        ENTITY clonedEntity = existingEntity.deepClone();
        return Optional.of(clonedEntity);
    }

    public Collection<ENTITY> findAll() {
        return store.values()
                .stream()
                .map(entity -> entity.deepClone())
                .collect(Collectors.toList());
    }
}
