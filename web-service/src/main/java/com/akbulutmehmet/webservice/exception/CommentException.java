package com.akbulutmehmet.webservice.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CommentException extends RuntimeException {
    public CommentException(String message) {
        super(message);
    }
}
