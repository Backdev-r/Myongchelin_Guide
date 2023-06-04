package com.example.demo.controller;

import com.example.demo.Like;
import com.example.demo.LikeListClass;
import com.example.demo.UserLike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LikeListController {



    @Autowired
    private final MongoTemplate mongoTemplate;
    @Autowired
    public LikeListController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
}
    @PostMapping("/likelist")
    public ResponseEntity<Object> like(@RequestBody LikeListClass likeListClass) {

        String userId = likeListClass.getUserId();

        Query query = new Query(Criteria.where("userId").is(userId));
        List<Like> likes = mongoTemplate.find(query, Like.class);

        return ResponseEntity.ok(likes);




        // 해당 userId와 일치하는 모든 데이터를 조회하여 반환





    }










}
