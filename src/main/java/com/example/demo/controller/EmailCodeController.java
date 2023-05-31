package com.example.demo.controller;

import com.example.demo.EmailCodecertify;
import com.example.demo.EmailVerificationRequest;
import com.univcert.api.UnivCert;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmailCodeController {


    @CrossOrigin(origins = "*")
    @PostMapping("/emailCode")
    public ResponseEntity<Object> codevalidation(@RequestBody EmailCodecertify emailCodecertify) {


        try {
            String apiKey = "2b30351d-dbff-489d-a0d5-14c3f80521c1";  //이거 내 api key로 바꾸기
            String email = emailCodecertify.getEmail();
            String universityName = "명지대학교";
            int cerNum = emailCodecertify.getCerNum();
            Map<String, Object> result = UnivCert.certifyCode(apiKey, email, universityName, cerNum);
            System.out.println(result.get("success"));
            // 이메일 인증 결과를 확인하여 적절한 응답을 반환할 수 있습니다.
            // 예를 들어, 인증 성공 시에는 HttpStatus.OK와 함께 성공 메시지를 반환할 수 있습니다.

            return ResponseEntity.ok("이메일인증에 성공하였습니다.");
        } catch (IOException e) {
            // 이메일 인증 요청 중에 예외가 발생한 경우, 적절한 예외 처리를 진행할 수 있습니다.
            // 예를 들어, HttpStatus.INTERNAL_SERVER_ERROR와 함께 에러 메시지를 반환할 수 있습니다.

            return ResponseEntity.badRequest().body("유효하지 않는 코드입니다.");
        }
    }
}
