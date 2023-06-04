package com.example.demo.controller;


import com.example.demo.Like;
import com.example.demo.UserLike;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
public class LikeController {

    @Autowired
    private final MongoTemplate mongoTemplate;
    @Autowired
    public LikeController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;

    }
    @PostMapping("/like")
    public ResponseEntity<Object> like( @RequestBody UserLike userLike) {

        String userId = userLike.getUserId();
        String restid = userLike.getRestid();
        Query query = new Query(Criteria.where("userId").is(userId).and("restid").is(restid));
        Like likes = mongoTemplate.findOne(query, Like.class);

        if (likes!=null) {
            // 이미 존재하는 데이터인 경우 삭제
            mongoTemplate.remove(likes);

            return ResponseEntity.ok("찜 해제완료");
        }

            // 존재하지 않는 데이터인 경우 추가
            Like newLike = new Like(userId, restid);
            mongoTemplate.save(newLike);
            // 해당 userId와 일치하는 모든 데이터를 조회하여 반환

            return ResponseEntity.ok("찜 등록 완료");



    }



}
