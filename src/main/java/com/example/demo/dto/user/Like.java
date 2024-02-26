package com.example.demo.dto.user;


import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Like {

    @Id
    private String id;

    private String userId;
    private String restid;

    public Like(String userId, String restid) {
        this.restid = restid;
        this.userId = userId;
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
