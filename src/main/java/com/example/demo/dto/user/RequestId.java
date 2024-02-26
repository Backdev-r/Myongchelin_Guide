package com.example.demo.dto.user;

import lombok.Data;

@Data
public class RequestId {

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
