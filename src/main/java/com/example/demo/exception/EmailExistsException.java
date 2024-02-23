package com.example.demo.exception;

public class EmailExistsException extends Exception {

    public EmailExistsException(String message) {
        super(message);
    }
}
