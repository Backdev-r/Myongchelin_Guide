package com.example.demo.image;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Restaurant_Review")
public class ImageDocument {
    @JsonProperty
    private String userId;
    @JsonProperty
    private String contents;
    @JsonProperty
    private double rate;
    @JsonProperty
    private String image;
    @JsonProperty
    private String name;

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

    public ImageDocument(String userId,String contents,double rate,String image,String name) {
        this.userId = userId;
        this.contents=contents;
        this.rate=rate;
        this.name = name;
        this.image = image;

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
// 생성자, getter, setter, 기타 메서드 생략

    // getters and setters
}