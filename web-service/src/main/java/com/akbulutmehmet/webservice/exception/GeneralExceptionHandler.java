package com.akbulutmehmet.webservice.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) ->{
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity<?> authorizationExceptionHandler(AuthorizationException authorizationException){
        return new ResponseEntity<>(authorizationException.getMessage(),HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(CategoryException.class)
    public ResponseEntity<?> categoryExceptionHandler(CategoryException categoryException){
        return new ResponseEntity<>(categoryException.getMessage(),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CommentException.class)
    public ResponseEntity<?> commentExceptionHandler(CommentException commentException){
        return new ResponseEntity<>(commentException.getMessage(),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(PostException.class)
    public ResponseEntity<?> postExceptionHandler(PostException postException){
        return new ResponseEntity<>(postException.getMessage(),HttpStatus.NOT_FOUND);
    }
}
