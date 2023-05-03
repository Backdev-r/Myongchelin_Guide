package com.example.demo;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

public class UserDto {

    @Id
    private String userId;

    @NotBlank
    private String nickName;

    @NotBlank
    private String userPw;



    public UserDto(String nickName,String userId,String userPw) {
        this.userId = userId;
        this.nickName = nickName;
        this.userPw = userPw;
    }
    public String getUsername() {
        return nickName;
    }
    public String getId() {
        return userId;
    }

    public String getPassword(){
        return userPw;
    }

    // getter, setter, toString
}
