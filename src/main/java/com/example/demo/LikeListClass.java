package com.example.demo;


import org.springframework.data.mongodb.core.mapping.Document;


public class LikeListClass {

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private String userId;

}
