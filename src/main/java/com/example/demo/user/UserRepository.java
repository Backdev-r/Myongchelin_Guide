package com.example.demo.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String nickName);
    User findByUserIdAndPassword(String userId, String userPw);

    User findByUserId(String userId);
}
