package ch.heigvd.amt.stackovergoat.application.user;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Singular;

import java.util.List;

@Builder
@Getter
@EqualsAndHashCode
public class UsersDTO {

    @Builder
    @Getter
    @EqualsAndHashCode
    public static class UserDTO {
        private String username;
    }

    @Singular
    private List<UserDTO> users;
}
