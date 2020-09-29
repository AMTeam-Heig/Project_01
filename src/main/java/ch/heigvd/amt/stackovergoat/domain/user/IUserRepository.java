package ch.heigvd.amt.stackovergoat.domain.user;

import ch.heigvd.amt.stackovergoat.application.user.UsersQuery;
import ch.heigvd.amt.stackovergoat.domain.IRepository;

import java.util.Collection;

public interface IUserRepository extends IRepository<User, UserId> {
    public Collection<User> find(UsersQuery query);
}
