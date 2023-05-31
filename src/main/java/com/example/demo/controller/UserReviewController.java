package com.example.demo.controller;

import com.example.demo.image.ReviewDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserReviewController {
    @Autowired
    private final MongoTemplate mongoTemplate;

    @Autowired
    public UserReviewController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/reviews")
    public ResponseEntity<Object> createReview(@RequestBody ReviewDocument request) {
        try {
            // 프론트엔드로부터 받은 데이터를 MongoDB에 저장//String userId, double rate, String contents, String name,String _id
            ReviewDocument review = new ReviewDocument(request.getUserId(),  request.getContents(),request.getRate(), request.getName(), request.getImage(),request.getRestid());

            review.setImage("");
            System.out.println(review.getImage());
            mongoTemplate.save(review, "Restaurant_Review");

            return ResponseEntity.ok("Review created successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create review.");
        }
    }
}