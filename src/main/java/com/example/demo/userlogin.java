package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class userlogin {
    @JsonProperty
    private String userId;
    @JsonProperty
    private String userPw;

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
