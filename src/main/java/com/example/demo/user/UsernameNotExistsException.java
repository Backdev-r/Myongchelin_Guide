package com.example.demo.user;

public class UsernameNotExistsException extends Exception {
    public UsernameNotExistsException(String message) {
        super(message);
    }
}
