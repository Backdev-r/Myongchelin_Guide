package com.example.demo;

public class EmailExistsException extends Exception {

    public EmailExistsException(String message) {
        super(message);
    }
}
