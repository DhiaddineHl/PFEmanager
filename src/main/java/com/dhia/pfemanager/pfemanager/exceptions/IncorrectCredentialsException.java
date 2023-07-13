package com.dhia.pfemanager.pfemanager.exceptions;

import org.springframework.security.core.AuthenticationException;

public class IncorrectCredentialsException extends AuthenticationException {

    public IncorrectCredentialsException(String msg) {
        super(msg);
    }
}
