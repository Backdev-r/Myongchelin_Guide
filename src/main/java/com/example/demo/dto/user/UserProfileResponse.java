package com.example.demo.dto.user;

import lombok.Data;

@Data
public class UserProfileResponse {

    private String email;
    private String userId;


    private String nickName;

    public UserProfileResponse(String email, String userId, String nickName) {
        this.email = email;
        this.userId = userId;
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}


