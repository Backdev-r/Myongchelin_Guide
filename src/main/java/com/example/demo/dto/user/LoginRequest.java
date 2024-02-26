package com.example.demo.dto.user;

import lombok.Data;

@Data
public class LoginRequest {

    private String userId;

    private String userPw;

    public LoginRequest() {
    }

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
