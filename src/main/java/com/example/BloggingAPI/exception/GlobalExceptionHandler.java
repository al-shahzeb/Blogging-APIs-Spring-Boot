package com.example.BloggingAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> resourceNotFoundException(ResourceNotFoundException msg){
        return new ResponseEntity<>(msg.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> methodArgumentNotValidException(MethodArgumentNotValidException msg){
        Map<String ,String> validation = new HashMap<>();
        msg.getBindingResult().getAllErrors().forEach(error->{
            String field = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            validation.put(field,message);
        });
        return new ResponseEntity<>(validation,HttpStatus.BAD_REQUEST);
    }
}
