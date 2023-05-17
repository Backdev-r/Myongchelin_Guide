package com.example.demo.user;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class UserDto {


    @NotBlank
    private String email;
    @NotBlank
    private String cerNum;
    @Id
    @NotBlank
    private String userId;

    @NotBlank
    private String nickName;

    public String getEmail() {
        return email;
    }

    public String getCerNum() {
        return cerNum;
    }

    @NotBlank
    private String userPw;

    public UserDto(){}

    public UserDto(String email, String cerNum, String nickName, String userId, String userPw) {
        this.email=email;
        this.cerNum=cerNum;
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
