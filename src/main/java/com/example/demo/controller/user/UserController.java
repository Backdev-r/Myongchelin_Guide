package com.example.demo.controller.user;

import com.example.demo.document.User;
import com.example.demo.dto.user.*;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @CrossOrigin(origins = "*")
    @PostMapping("/name")
    public ResponseEntity<Object> namevalidation(@RequestBody nickNameRequest request) {

        boolean isNickNameAvailable = userService.checkNicknameAvailability(request.getNickName());
        if (!isNickNameAvailable) {
            return ResponseEntity.badRequest().body("닉네임 중복!");
        }
        return ResponseEntity.ok("닉네임 검증 통과!");
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/id")
    public ResponseEntity<Object> idvalidation(@RequestBody userIdRequest request) {
        boolean isUserIdAvailable = userService.checkUserIdAvailability(request.getUserId());
        if (!isUserIdAvailable) {
            return ResponseEntity.badRequest().body("아이디 중복!");
        }
        return ResponseEntity.ok("아이디 검증 통과!");
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody User user) {

        // 중복 확인을 모두 통과한 경우 회원가입 로직 수행
        userService.registerNewUserAccount(user);

        return ResponseEntity.ok("Signup successful");
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/findPw")
    public ResponseEntity<String> findUserPwById(@RequestBody RequestPw requestPw) {
        String userId = requestPw.getUserId();
        String userEmail = requestPw.getEmail();

        User user = userRepository.findByEmailAndId(userEmail, userId);

        if (user != null) {
            String userPw = user.getUserPw();
            return ResponseEntity.ok("password :" + userPw);
        } else {
            return ResponseEntity.badRequest().body("아이디 혹은 이메일을 다시입력해주세요");
        }
    }

    @CrossOrigin(origins = "*")
    @PatchMapping("/changePw")
    public ResponseEntity<Object> changePassword(@RequestBody UserPwChange userPwChange) {

        String userId = userPwChange.getUserId();
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

    @CrossOrigin(origins = "*")
    @PostMapping("/findId")
    public ResponseEntity<String> findUserIdByEmail(@RequestBody RequestId requestId) {
        String email = requestId.getEmail();
        User user = userRepository.findByEmail(email);

        if (user != null) {
            String userId = user.getId();
            return ResponseEntity.ok("id :" + userId);
        } else {
            return ResponseEntity.badRequest().body("이메일을 다시 입력해주세요");
        }
    }

    @CrossOrigin(origins = "*")   //
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody userlogin user1) {
        String userId = user1.getUserId();
        String userPw = user1.getUserPw();

        User user = userRepository.findByUserIdAndPassword(userId, userPw);


        if (user != null) {
            return ResponseEntity.ok(user.getId());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("회원가입부터 시작하세요");
        }
    }
}





