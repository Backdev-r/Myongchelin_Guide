package com.example.demo.controller;


import com.example.demo.UserProfileResponse;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyPageController {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    public MyPageController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/mypage")
    public ResponseEntity<Object> getUserProfile(HttpServletRequest httpRequest){
        String sessionId = getSessionIdFromCookie(httpRequest);
        if (sessionId == null) {
            return ResponseEntity.badRequest().body("쿠키에서 세션 ID를 찾을 수 없습니다.");
        }
        String userId = getUserIdFromSession(sessionId,httpRequest);
        if (userId == null) {
            return ResponseEntity.badRequest().body("유효하지 않은 세션 ID입니다.");
        }
        // Retrieve user data from MongoDB using the userId
        User user = userRepository.findByUserId(userId);
        if (user != null) {
            // Create a response object with email, userId, and nickName
            UserProfileResponse response = new UserProfileResponse(user.getEmail(), user.getId(), user.getUsername());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
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
