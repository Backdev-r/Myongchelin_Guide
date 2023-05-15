package com.example.demo.controller;

import com.example.demo.*;
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
    public String login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getNickName();
        String password = loginRequest.getUserPw();

        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user != null) {
            return "Login successful";
        } else {
            return "fail!!Invalid username or password";
        }
    }
}
