package com.example.demo.controller.user;


import com.example.demo.dto.user.UserProfileResponse;
import com.example.demo.document.User;
import com.example.demo.dto.user.UserIdClass;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class MyPageController {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    public MyPageController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/my-page")
    public ResponseEntity<Object> getUserProfile(@RequestBody UserIdClass userIdClass){

        // Retrieve user data from MongoDB using the userId
        User user = userRepository.findByUserId(userIdClass.getUserId());
        System.out.println(user);
        if (user != null) {
            // Create a response object with email, userId, and nickName
            UserProfileResponse response = new UserProfileResponse(user.getEmail(), user.getId(), user.getUsername());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body("로그인을 하세요");
        }
    }




}
