package com.example.demo.controller;

import com.example.demo.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;


    @CrossOrigin(origins = "*")
    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody UserDto userDto) {
        try {
            userService.registerNewUserAccount(userDto);
            return ResponseEntity.ok("User registered successfully.");
        } catch (EmailExistsException | UsernameExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest) {
        String userId = loginRequest.getUserId();
        String pw = loginRequest.getUserPw();

        User user = userRepository.findByUsernameAndPassword(userId, pw);
        if(user !=null){
            return ResponseEntity.ok("Login successful!");
        }
        else{
            return ResponseEntity.ok("sorry,login failed!");

        }
    }



    }

