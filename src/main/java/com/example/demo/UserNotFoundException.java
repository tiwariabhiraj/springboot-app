package com.example.demo;

public class UserNotFoundException extends RuntimeException{
    UserNotFoundException(String message){
        super(message);
    }
}