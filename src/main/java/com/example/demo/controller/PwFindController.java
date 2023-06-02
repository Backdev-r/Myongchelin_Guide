package com.example.demo.controller;

import com.example.demo.RequestId;
import com.example.demo.RequestPw;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import com.example.demo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PwFindController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @CrossOrigin(origins = "*")
    @PostMapping("/findpw")
    public ResponseEntity<String> findUserPwById(@RequestBody RequestPw requestPw) {
        String userId = requestPw.getUserId();
        String userEmail = requestPw.getEmail();

        User user  = userRepository.findByEmailAndId(userEmail,userId);

        if (user != null) {
            String userPw = user.getUserPw();
            return ResponseEntity.ok("password :" +userPw);
        } else {
            return ResponseEntity.badRequest().body("아이디 혹은 이메일을 다시입력해주세요");
        }
    }
}
