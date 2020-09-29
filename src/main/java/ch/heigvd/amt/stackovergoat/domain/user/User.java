package ch.heigvd.amt.stackovergoat.domain.user;

import ch.heigvd.amt.stackovergoat.domain.IEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder(toBuilder = true)
public class User implements IEntity {

    @Setter(AccessLevel.NONE)
    private UserId id = new UserId();

    private String firstname;

    private String lastname;

    private String username;

    private String email;

    private String password;

    public static class UserBuilder {
        public User build() {
            if(id == null) {
                id = new UserId();
            }

            if(firstname == null) {
                firstname = "Mr/Mrs";
            }

            if(lastname == null) {
                lastname = "Anonymous";
            }

            if(username == null) {
                username = "anonymous";
            }

            if(email == null) {
                email = "who@anon.com";
            }

            if(password == null) {
                password = "";
            }

            return new User(id, firstname, lastname, username, email, password);
        }
    }
}
