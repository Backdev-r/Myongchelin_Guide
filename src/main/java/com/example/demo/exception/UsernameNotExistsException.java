package com.example.demo.exception;

public class UsernameNotExistsException extends Exception {
    public UsernameNotExistsException(String message) {
        super(message);
    }
}
