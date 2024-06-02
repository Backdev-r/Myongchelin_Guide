package com.example.demo.controller.review;

import com.example.demo.Entity.Review;
import com.example.demo.dto.review.ReviewRequest;
import com.example.demo.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class UserReviewController {
    @Autowired
    private final MongoTemplate mongoTemplate;
    @Autowired
    private final ReviewRepository reviewRepository;


    @CrossOrigin(origins = "*")
    @PostMapping("/add")
    public ResponseEntity<Object> createReview(@RequestBody Review request) {
        try {


            // 프론트엔드로부터 받은 데이터를 MongoDB에 저장//String userId, double rate, String contents, String name,String _id
            Review review = new Review(request.getUserId(), request.getContents(), request.getRate(), request.getName(), request.getImage(), request.getRestid());
            review.setImage("");

            System.out.println(review.getImage());
            mongoTemplate.save(review, "Restaurant_Review");

            return ResponseEntity.ok(review);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create review.");
        }
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/show/all")
    public List<Review> getAllReviews() {
        List<Review> reviews = mongoTemplate.findAll(Review.class, "Restaurant_Review");
        return reviews;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/show/user")
    public List<Review> getReviews(@RequestBody ReviewRequest request) {
        List<Review> reviews = reviewRepository.findReviewsByUserId(request.getUserId());
        return reviews;
    }


}