package com.akbulutmehmet.profileservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProfileException extends RuntimeException{
    public ProfileException(String message) {
        super(message);
    }
}
