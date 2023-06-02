package com.example.demo.user;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // vite 쓰는 리액트에서 오리진 요청을 열어줘야함 (포트 주의)
                .allowedMethods("*") // http 모든 메소드 요청 허용
                .allowedHeaders("*") // 헤더 정보 모두 허용
                .allowCredentials(true); // 쿠키, 세션 정보도 허용
    }
}
