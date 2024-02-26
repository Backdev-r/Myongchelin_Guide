package com.example.demo.dto.user;

import lombok.Data;

@Data
public class nickNameRequest {
    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}