package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Restaurant_Review")
public class Review {


    public Review() {
    }

    @Id
    private String _id; // 몽고DB의 고유식별자인 _id 필드
    private String userId;
    private String contents;
    private double rate;


    private String image;
    private String name;
    @JsonProperty("restid")
    private String restid; // 프론트엔드에서 전달된 id 값을 그대로 저장

    public Review(String userId, String contents, double rate, String name, String image, String restid) {
        this.userId = userId;
        this.contents = contents;
        this.rate = rate;
        this.image = image;
        this.name = name;
        this.restid = restid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRestid() {
        return restid;
    }

    public void setRestid(String id) {
        this.restid = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}