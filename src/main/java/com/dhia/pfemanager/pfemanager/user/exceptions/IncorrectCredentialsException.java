package com.dhia.pfemanager.pfemanager.user.exceptions;

import org.springframework.security.core.AuthenticationException;

public class IncorrectCredentialsException extends AuthenticationException {

    public IncorrectCredentialsException(String msg) {
        super(msg);
    }
}
