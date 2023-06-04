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
    public ResponseEntity<Object> like(HttpServletRequest httpRequest, @RequestBody UserLike userLike){
        String sessionId = getSessionIdFromCookie(httpRequest);

        String userId = getUserIdFromSession(sessionId,httpRequest);

        System.out.println(userId);

        String restid = userLike.getRestid();
        Query query = new Query(Criteria.where("userId").is(userId).and("restid").is(restid));
        Like like = mongoTemplate.findOne(query,  Like.class);

        if (like != null) {
            // 이미 존재하는 데이터인 경우 삭제
            mongoTemplate.remove(like);
            return ResponseEntity.ok("찜 등록실패");
        } else {
            // 존재하지 않는 데이터인 경우 추가
            Like like1 = new Like(userId,restid);
            mongoTemplate.save(like1 );
            return ResponseEntity.ok(like1 +"찜 등록 성공 ");
        }








    }

    private String getUserIdFromSession(String sessionId, HttpServletRequest httpRequest) {
        HttpSession session = httpRequest.getSession(false);
        if (session != null && session.getId().equals(sessionId)) {
            Object userId = session.getAttribute("userId");
            if (userId != null) {
                return userId.toString();
            }
        }
        return null;
    }

    private String getSessionIdFromCookie(HttpServletRequest httpRequest) {
        Cookie[] cookies = httpRequest.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    return cookie.getValue();
                }
            }
        }
        return null;

    }

}
