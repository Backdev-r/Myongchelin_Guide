package com.example.demo.dto.user;

import lombok.Data;

@Data
public class UserPwChange {


    private String userId;
    private String userPw;

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
