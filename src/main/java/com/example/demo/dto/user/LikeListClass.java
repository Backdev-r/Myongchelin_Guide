package com.example.demo.dto.user;


import lombok.Data;

@Data
public class LikeListClass {

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private String userId;

}
