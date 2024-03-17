package com.example.demo.document;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {


    @JsonProperty
    @NotBlank
    private String email;


    @JsonProperty("nick_name")
    @NotBlank
    private String nickName;
    @JsonProperty
    @NotBlank
    private String userId;
    @JsonProperty
    @NotBlank
    private String userPw;

    public User(String email, String nickName, String userId, String userPw) {

        this.email = email;
        this.nickName = nickName;
        this.userId = userId;
        this.userPw = userPw;
    }

    public User() {
    }

    public String getId() {
        return userId;
    }


    public void setId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setUsername(String nickName) {
        this.nickName = nickName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }
}

