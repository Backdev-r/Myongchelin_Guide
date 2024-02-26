package com.example.demo.dto.user;

import lombok.Data;

@Data
public class userIdRequest {

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


}
