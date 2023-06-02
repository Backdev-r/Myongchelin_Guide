package com.example.demo.controller;

import com.example.demo.UserPwChange;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserPwChangeController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @CrossOrigin(origins = "*")
    @PostMapping("/changePassword")
    public ResponseEntity<Object> changePassword(@RequestBody UserPwChange userPwChange,
                                                 HttpServletRequest httpRequest) {
        String sessionId = getSessionIdFromCookie(httpRequest);
        if (sessionId == null) {
            return ResponseEntity.badRequest().body("쿠키에서 세션 ID를 찾을 수 없습니다.");
        }
        String userId = getUserIdFromSession(sessionId,httpRequest);
        if (userId == null) {
            return ResponseEntity.badRequest().body("유효하지 않은 세션 ID입니다.");
        }

        String userPw = userPwChange.getUserPw();
        System.out.println(userPw);

        // 기존의 userPw 값과 비교하여 같으면 에러를 반환합니다.
        Query query = Query.query(Criteria.where("userId").is(userId));
        User user = mongoTemplate.findOne(query, User.class, "users");
        if (user != null && userPw.equals(user.getUserPw())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("새로운 비밀번호는 이전 비밀번호와 동일할 수 없습니다.");
        }
        try {
            Query query1 = Query.query(Criteria.where("userId").is(userId));
            Update update = Update.update("userPw", userPw);
            mongoTemplate.updateFirst(query1, update, "users");

            return ResponseEntity.ok("비밀번호가 성공적으로 변경되었습니다!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("비밀번호 변경 실패");
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

