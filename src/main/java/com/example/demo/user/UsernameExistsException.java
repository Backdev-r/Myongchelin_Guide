package com.example.demo.user;

public class UsernameExistsException extends Exception {

    public UsernameExistsException(String message) {
        super(message);
    }
}
