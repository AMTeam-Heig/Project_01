package ch.heigvd.amt.stackovergoat.domain.user;

import ch.heigvd.amt.stackovergoat.domain.IEntity;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@Builder(toBuilder = true)
public class User implements IEntity<User, UserId> {

    private UserId id;
    private String firstname;
    private String lastname;
    private String username;
    private String email;

    @EqualsAndHashCode.Exclude
    private String encryptedPassword;

    public boolean authenticate(String clearTextPassword)
    {
        return clearTextPassword.toUpperCase().equals(encryptedPassword);
    }

    @Override
    public User deepClone() {
        return this.toBuilder()
                .id(new UserId(id.asString()))
                .build();
    }

    @Override
    public UserId getId() {
        return null;
    }

    public String getUsername() {
        return username;
    }

    public static class UserBuilder {

        public UserBuilder clearTextPassword(String clearTextPassword) {
            if (clearTextPassword == null || clearTextPassword.isEmpty()) {
                throw new java.lang.IllegalArgumentException("Password is mandatory.");
            }
            build().encryptedPassword = clearTextPassword.toUpperCase();
            return this;
        }

        public User build() {
            if(id == null) {
                id = new User(id);
            }

            if(build().username == null || build().username.isEmpty()) {
                throw new java.lang.IllegalArgumentException("Username is mandatory.");
            }
            if(build().encryptedPassword == null || build().encryptedPassword.isEmpty()) {
                throw new java.lang.IllegalArgumentException("Password is mandatory.");
            }
            if(build().firstname == null || build().firstname.isEmpty()) {
                throw new java.lang.IllegalArgumentException("Firstname is mandatory.");
            }
            if(build().lastname == null || build().lastname.isEmpty()) {
                throw new java.lang.IllegalArgumentException("Lastname is mandatory.");
            }
            if(build().email == null || build().email.isEmpty()) {
                throw new java.lang.IllegalArgumentException("email is mandatory.");
            }

            User newUser = new User(build().id, build().username, build().email, build().firstname, build().lastname, build().encryptedPassword);
            return newUser;
        }
    }
}
