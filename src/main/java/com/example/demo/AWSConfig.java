package com.example.demo;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSConfig {

    /**
     * Key는 중요정보이기 때문에 properties 파일에 저장한 뒤 가져와 사용하는 방법이 좋습니다.
     */
    private String iamAccessKey = "AKIASRVY6WTPKI6BYOGH"; // IAM Access Key
    private String iamSecretKey = "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"; // IAM Secret Key
    private String region = "ap-northeast-2"; // Bucket Region

    @Bean
    public AmazonS3Client amazonS3Client() {
        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(iamAccessKey, iamSecretKey);
        return (AmazonS3Client) AmazonS3ClientBuilder.standard()
                .withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
                .build();
    }
}

