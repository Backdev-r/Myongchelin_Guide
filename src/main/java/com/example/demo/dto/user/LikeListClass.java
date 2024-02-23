package com.example.demo.dto.user;


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
