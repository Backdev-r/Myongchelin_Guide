package com.example.demo;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
    //email cerNum nickName userId userPw




    @Id
    private String userId;
    @NotBlank
    private String nickName;

    @NotBlank
    private String userPw;

    public User(String nickName,String userId,String userPw){
        this.nickName=nickName;
        this.userId=userId;
        this.userPw=userPw;
    }

    public String getId() {
        return userId;
    }

    public void setId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return nickName;
    }

    public void setUsername(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return userPw;
    }

    public void setPassword(String password) {
        this.userPw = password;
    }



    // getter, setter, constructor
}