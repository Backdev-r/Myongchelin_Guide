package com.example.demo.controller.user;


import com.example.demo.dto.user.Like;
import com.example.demo.dto.user.LikeListClass;
import com.example.demo.dto.user.UserLike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review/like")
public class LikeController {

    @Autowired
    private final MongoTemplate mongoTemplate;
    @Autowired
    public LikeController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;

    }@CrossOrigin(origins = "*")
    @PostMapping("/add")
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



    }@CrossOrigin(origins = "*")
    @GetMapping("/list")
    public ResponseEntity<Object> like(@RequestBody LikeListClass likeListClass) {

        String userId = likeListClass.getUserId();

        Query query = new Query(Criteria.where("userId").is(userId));
        List<Like> likes = mongoTemplate.find(query, Like.class);

        return ResponseEntity.ok(likes);

    }



}
