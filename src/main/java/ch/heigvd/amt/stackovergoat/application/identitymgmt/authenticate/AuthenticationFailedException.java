package ch.heigvd.amt.stackovergoat.application.identitymgmt.authenticate;

import ch.heigvd.amt.stackovergoat.application.BusinessException;

public class AuthenticationFailedException extends BusinessException {
    public AuthenticationFailedException(String message) {
        super(message);
    }
}
