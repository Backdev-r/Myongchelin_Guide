package com.example.demo.controller;

import com.example.demo.EmailExistsException;
import com.example.demo.UserDto;
import com.example.demo.UserService;
import com.example.demo.UsernameExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;


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
}
