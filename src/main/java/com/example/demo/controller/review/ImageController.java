package com.example.demo.controller.review;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.demo.Entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ImageController {

    private String S3Bucket = "bucket123478"; // Bucket 이름

    private final AmazonS3Client amazonS3Client;
    private final MongoTemplate mongoTemplate;



    @CrossOrigin(origins = "*")
    @PostMapping("/image/upload")
    public ResponseEntity<Object> upload(MultipartFile multipartFileList) throws Exception {
        List<String> imagePathList = new ArrayList<>();

        String originalName = multipartFileList.getOriginalFilename(); // 파일 이름
        System.out.println(originalName);
        long size = multipartFileList.getSize(); // 파일 크기


        ObjectMetadata objectMetaData = new ObjectMetadata();
        objectMetaData.setContentType(multipartFileList.getContentType());
        objectMetaData.setContentLength(size);

        // S3에 업로드
        amazonS3Client.putObject(new PutObjectRequest(S3Bucket, originalName, multipartFileList.getInputStream(), objectMetaData).withCannedAcl(CannedAccessControlList.PublicRead));

        String imagePath = amazonS3Client.getUrl(S3Bucket, originalName).toString(); // 접근가능한 URL 가져오기
        imagePathList.add(imagePath);
        if (!imagePathList.isEmpty()) {
            // 마지막 리뷰 데이터에 이미지 URL 저장
            String lastReviewId = getLastReviewIdFromMongoDB();
            if (lastReviewId != null) {
                Query query = new Query(Criteria.where("_id").is(lastReviewId));
                mongoTemplate.updateFirst(query, new Update().set("image", imagePathList.get(0)), "Restaurant_Review");


            }
        }
        return new ResponseEntity<Object>(imagePathList, HttpStatus.OK);
    }


    private String getLastReviewIdFromMongoDB() {
        Query query = new Query().with(Sort.by(Sort.Direction.DESC, "_id")).limit(1);
        Review lastReview = mongoTemplate.findOne(query, Review.class, "Restaurant_Review");
        if (lastReview != null) {
            return lastReview.get_id();
        }
        return null;
    }


}

