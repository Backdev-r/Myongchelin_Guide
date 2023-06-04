package com.example.demo.controller;


import com.example.demo.UserProfileResponse;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
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
    public ResponseEntity<Object> getUserProfile(UserIdClass userIdClass){

        // Retrieve user data from MongoDB using the userId
        User user = userRepository.findByUserId(userIdClass.getUserId());
        if (user != null) {
            // Create a response object with email, userId, and nickName
            UserProfileResponse response = new UserProfileResponse(user.getEmail(), user.getId(), user.getUsername());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body("로그인을 하세요");
        }
    }




}
