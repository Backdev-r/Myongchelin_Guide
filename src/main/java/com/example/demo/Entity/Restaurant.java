package com.example.demo.Entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Restaurant_restaurants")
public class Restaurant {
    @Id
    private String id;
    private String name;
    private List<String> likers; // 동적 필드


public Restaurant(){}

    public void addLiker(String follower) {
        if (!likers.contains(follower)) {
            this.likers.add(follower);
        }
    }

    public void removeLiker(String follower) {
        this.likers.remove(follower);
    }
}