package com.example.demo.controller;

import com.example.demo.RequestId;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import com.example.demo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class IdFindController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @CrossOrigin(origins = "*")
    @PostMapping("/findid")
    public ResponseEntity<String> findUserIdByEmail(@RequestBody RequestId requestId) {
        String email = requestId.getEmail();
        User user = userRepository.findByEmail(email);

        if (user != null) {
            String userId = user.getId();
            return ResponseEntity.ok("id :" +userId);
        } else {
            return ResponseEntity.badRequest().body("이메일을 다시 입력해주세요");
        }
    }
}
