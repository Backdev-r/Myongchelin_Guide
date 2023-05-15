package com.example.demo.user;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank
    private String userId;
    @NotBlank
    private String userPw;

    public LoginRequest(){}
    public LoginRequest(String userId, String userPw) {
        this.userId = userId;
        this.userPw = userPw;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }
}
