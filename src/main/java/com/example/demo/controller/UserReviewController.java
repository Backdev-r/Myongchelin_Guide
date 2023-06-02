package com.example.demo.controller;

import com.example.demo.image.ReviewDocument;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
    public ResponseEntity<Object> createReview(@RequestBody ReviewDocument request, HttpServletRequest httpRequest) {
        try {
            // 세션 ID를 쿠키에서 추출
            String sessionId = getSessionIdFromCookie(httpRequest);

            // 세션 ID를 사용하여 userId를 얻어오기
            String userId = getUserIdFromSession(sessionId,httpRequest);

            // 프론트엔드로부터 받은 데이터를 MongoDB에 저장//String userId, double rate, String contents, String name,String _id
            ReviewDocument review = new ReviewDocument(userId,  request.getContents(),request.getRate(), request.getName(), request.getImage(),request.getRestid());
            review.setImage("");
            review.setUserId(userId);
            System.out.println(review.getImage());
            mongoTemplate.save(review, "Restaurant_Review");

            return ResponseEntity.ok("Review created successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create review.");
        }
    }


    private String getUserIdFromSession(String sessionId,HttpServletRequest httpRequest) {
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