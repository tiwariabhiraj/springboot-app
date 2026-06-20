package com.example.demo;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public String exceptionHandlerClass(UserNotFoundException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(Exception.class)
    public String handleGeneric(Exception ex) {
        return "Something went wrong";
    }
}