package com.example.demo.controller;


import com.example.demo.image.ReviewDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ImageController {
    @Autowired
    private final MongoTemplate mongoTemplate;

    @Autowired
    public ImageController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/showreviews")  //기존에 /images였는데 바꿈
    public List<ReviewDocument> getAllReviews() {
        List<ReviewDocument> reviews = mongoTemplate.findAll(ReviewDocument.class, "Restaurant_Review");
        return reviews;
    }
}