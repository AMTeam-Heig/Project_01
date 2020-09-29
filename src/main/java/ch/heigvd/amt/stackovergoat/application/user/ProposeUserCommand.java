package ch.heigvd.amt.stackovergoat.application.user;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class ProposeUserCommand {
    @Builder.Default
    private String username = "anonymous";
}
