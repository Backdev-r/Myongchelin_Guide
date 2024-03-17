package com.example.demo.service;

import com.example.demo.document.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public User registerNewUserAccount(User user) {

        User user1 = new User(user.getEmail(), user.getNickName(), user.getId(), user.getUserPw());
        return userRepository.save(user1);
    }

    @Override
    public boolean checkNicknameAvailability(String nickName) {
        User existingUser = userRepository.findByUsername(nickName);
        System.out.println(existingUser);
        return existingUser == null;
    }

    @Override
    public boolean checkUserIdAvailability(String userId) {
        User existingUser = userRepository.findByUserId(userId);
        return existingUser == null;
    }
}
