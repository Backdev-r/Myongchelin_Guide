package com.example.demo.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "users1")
public class User {
    //email cerNum nickName userId userPw

    @JsonProperty
    @NotBlank
    private String email;
    @JsonProperty
    @NotBlank
    private String cerNum;
    @JsonProperty
    @NotBlank
    private String nickName;
    @JsonProperty
    @NotBlank
    private String userId;
    @JsonProperty
    @NotBlank
    private String userPw;

    public User(String email, String cerNum, String nickName, String userId, String userPw){
        this.email=email;
        this.cerNum=cerNum;

        this.nickName=nickName;
        this.userId=userId;
        this.userPw=userPw;
    }
    public User() {
    }

    public String getId() {
        return userId;
    }
    public String getEmail() {
        return email;
    }

    public String getCerNum() {
        return cerNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCerNum(String cerNum) {
        this.cerNum = cerNum;
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