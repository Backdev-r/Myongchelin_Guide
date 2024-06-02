package com.example.demo.Entity;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document(collection = "users")
public class User {


    @NotBlank
    private String email;



    @NotBlank
    private String nickName;

    @NotBlank
    private String userId;

    @NotBlank
    private String userPw;

    private List<String> likedRestaurantIds;
    public User(String email, String nickName, String userId, String userPw) {

        this.email = email;
        this.nickName = nickName;
        this.userId = userId;
        this.userPw = userPw;
        this.likedRestaurantIds = null;  // 초기값으로 null 설정
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
    public void addLikedRestaurantId(String restaurantId) {
        if (this.likedRestaurantIds == null) {
            this.likedRestaurantIds = new ArrayList<>();
        }
        if (!this.likedRestaurantIds.contains(restaurantId)) {
            this.likedRestaurantIds.add(restaurantId);
        }
    }

    public void removeLikedRestaurantId(String restaurantId) {
        if (this.likedRestaurantIds != null) {
            this.likedRestaurantIds.remove(restaurantId);
        }
    }
}

