package com.example.demo.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "users")
public class User {
    // nickName userId userPw



    @JsonProperty
    @NotBlank
    private String nickName;
    @JsonProperty
    @NotBlank
    private String userId;
    @JsonProperty
    @NotBlank
    private String userPw;

    public User( String nickName, String userId, String userPw){


        this.nickName=nickName;
        this.userId=userId;
        this.userPw=userPw;
    }
    public User() {
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