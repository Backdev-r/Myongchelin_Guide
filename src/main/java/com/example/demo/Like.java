package com.example.demo;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "like")
public class Like {

    @Id
    private String id;

    private String userId;
    private String restid;

    public Like(String userId, String restid) {
        this.restid=restid;
        this.userId=userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRestid() {
        return restid;
    }

    public void setRestid(String restid) {
        this.restid = restid;
    }


}
