package com.example.demo.user;

public class EmailExistsException extends Exception {

    public EmailExistsException(String message) {
        super(message);
    }
}
