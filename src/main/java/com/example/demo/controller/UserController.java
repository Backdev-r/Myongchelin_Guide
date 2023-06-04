package com.example.demo.controller;

import com.example.demo.nickNameRequest;
import com.example.demo.user.*;
import com.example.demo.userIdRequest;
import com.example.demo.userlogin;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @PostMapping("/name")
    public ResponseEntity<Object> namevalidation(@RequestBody nickNameRequest request){ //이부분 중요 요청받을때 객체로 변환시켜야됨

        boolean isNickNameAvailable = userService.checkNicknameAvailability(request.getNickName());
        if (!isNickNameAvailable) {
            return ResponseEntity.badRequest().body("닉네임 중복!");
        }
        return ResponseEntity.ok("닉네임 검증 통과!");
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/id")
    public ResponseEntity<Object> idvalidation(@RequestBody userIdRequest request){
        boolean isUserIdAvailable = userService.checkUserIdAvailability(request.getUserId());
        if (!isUserIdAvailable ) {
            return ResponseEntity.badRequest().body("아이디 중복!");
        }
        return ResponseEntity.ok("아이디 검증 통과!");
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody User user)  {

        // 중복 확인을 모두 통과한 경우 회원가입 로직 수행
        userService. registerNewUserAccount(user);

        return ResponseEntity.ok("Signup successful");
    }
   @CrossOrigin(origins = "http://localhost:3000/")   //
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody userlogin user1, HttpServletRequest request,
        HttpServletResponse response) {
        String userId = user1.getUserId();
        String userPw = user1.getUserPw();

        User user = userRepository.findByUserIdAndPassword(userId, userPw);

       if (user != null) {
           // 기존 세션 무효화
           HttpSession oldSession = request.getSession(false);
           if (oldSession != null) {
               oldSession.invalidate();
           }
           // 새로운 세션 생성
           HttpSession newSession = request.getSession(true);

           newSession.setAttribute("userId", user.getId());
           newSession.setMaxInactiveInterval(1800);
// 쿠키를 직접 생성하여 JavaScript에서 조작할 수 있도록 설정
           Cookie cookie = new Cookie("JSESSIONID", newSession.getId());
           cookie.setDomain("52.79.235.187");
           cookie.setPath("/");
           cookie.setHttpOnly(false); // httponly를 false로 설정
           response.addCookie(cookie);
           // 응답 헤더에 쿠키 추가

           Object a = newSession.getId();
           System.out.println(a);
           return ResponseEntity.ok("Login successful!");
       }
        else{
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Sorry, login failed!");

        }
    }



    }

