package com.example.demo.user;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "users1")
public class User {
    //email cerNum nickName userId userPw
    @NotBlank
    private String email;
    @NotBlank
    private String cerNum;




    @Id
    private String userId;
    @NotBlank
    private String nickName;

    @NotBlank
    private String userPw;

    public String getEmail() {
        return email;
    }

    public String getCerNum() {
        return cerNum;
    }

    public User(String email, String cerNum, String nickName, String userId, String userPw){
        this.email=email;
        this.cerNum=cerNum;

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