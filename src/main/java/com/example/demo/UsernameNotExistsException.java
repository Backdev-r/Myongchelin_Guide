package com.example.demo;

public class UsernameNotExistsException extends Exception {
    public UsernameNotExistsException(String message) {
        super(message);
    }
}
