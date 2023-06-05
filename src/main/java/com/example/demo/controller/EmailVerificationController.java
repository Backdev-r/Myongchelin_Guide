package com.example.demo.controller;

import com.example.demo.EmailVerificationRequest;
import com.univcert.api.UnivCert;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class EmailVerificationController {


    @CrossOrigin(origins = "*")
    @PostMapping("/email")
    public ResponseEntity<Object> startEmailVerification(@RequestBody EmailVerificationRequest request) {


        try {
            Map<String, Object> result = UnivCert.clear("13cd873f-9c5c-48c4-b6bd-eba0f9006dee");
            String apiKey = "13cd873f-9c5c-48c4-b6bd-eba0f9006dee";
            String email = request.getEmail();
            String universityName = "명지대학교";
            boolean univCheck = true;
            Map<String, Object> result1 = UnivCert.certify(apiKey, email, universityName, univCheck);

            // 이메일 인증 결과를 확인하여 적절한 응답을 반환할 수 있습니다.
            // 예를 들어, 인증 성공 시에는 HttpStatus.OK와 함께 성공 메시지를 반환할 수 있습니다.
            if(result1.get("success").equals(false))
                return ResponseEntity.badRequest().body("이메일 인증이 실패하였거나 일일 시도가능 횟수 초과입니다.");
            return ResponseEntity.ok("인증메일이 발송되었습니다.");
        } catch (IOException e) {
            // 이메일 인증 요청 중에 예외가 발생한 경우, 적절한 예외 처리를 진행할 수 있습니다.
            // 예를 들어, HttpStatus.INTERNAL_SERVER_ERROR와 함께 에러 메시지를 반환할 수 있습니다.

            return ResponseEntity.badRequest().body("이메일 인증이 실패하였습니다.");
        }
    }
}
