package com.dhia.pfemanager.pfemanager.errors;


import com.dhia.pfemanager.pfemanager.user.exceptions.EmailTakenException;
import com.dhia.pfemanager.pfemanager.user.exceptions.EnterpriseBlockedException;
import com.dhia.pfemanager.pfemanager.user.exceptions.EnterpriseNotFoundException;
import com.dhia.pfemanager.pfemanager.user.exceptions.IncorrectCredentialsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class AppExceptionsHandler {

    @ExceptionHandler(EmailTakenException.class)
    public ResponseEntity<ErrorResponse> handleEmailTakenException
            (
                    EmailTakenException exception,
                    WebRequest request
                    ) {
        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setStatusCode(HttpStatus.FORBIDDEN.value());
        errorResponse.setErrorMessage(exception.getMessage());
        errorResponse.setTimestamps(new Date());

        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.FORBIDDEN);
    }


    @ExceptionHandler(EnterpriseNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEnterpriseNotFoundException
            (
                    EnterpriseNotFoundException exception,
                    WebRequest request
                    ) {
        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setStatusCode(HttpStatus.FORBIDDEN.value());
        errorResponse.setErrorMessage(exception.getMessage());
        errorResponse.setTimestamps(new Date());

        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(EnterpriseBlockedException.class)
    public ResponseEntity<ErrorResponse> handleEnterpriseBlockedException
            (
                    EnterpriseBlockedException exception,
                    WebRequest request
                    ) {
        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setStatusCode(HttpStatus.FORBIDDEN.value());
        errorResponse.setErrorMessage(exception.getMessage());
        errorResponse.setTimestamps(new Date());

        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleBadCredentialsException
            (
                    BadCredentialsException exception,
                    WebRequest request
                    ) {
        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setStatusCode(HttpStatus.UNAUTHORIZED.value());
        errorResponse.setErrorMessage("Invalid email or password");
        errorResponse.setTimestamps(new Date());

        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

}
