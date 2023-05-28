package com.example.demo.controller;

import com.example.demo.image.ImageDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecommendController {
    @Autowired
    private final MongoTemplate mongoTemplate;

    public RecommendController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/recommend")
    public List<ImageDocument> getTopRatedReviews() {
        Query query = new Query().with(Sort.by(Sort.Direction.DESC, "rate")).limit(4);
        List<ImageDocument> topRatedReviews = mongoTemplate.find(query, ImageDocument.class, "Restaurant_Review");
        return topRatedReviews;
    }
}
