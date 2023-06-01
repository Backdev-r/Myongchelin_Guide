package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public User registerNewUserAccount(User user)  {

        User user1 = new User(user.getEmail(), user.getUsername(),user.getId(), user.getUserPw());
        return userRepository.save(user1);
    }

    @Override
    public boolean checkNicknameAvailability(String username) {
        User existingUser = userRepository.findByUsername(username);
        return existingUser == null;
    }

    @Override
    public boolean checkUserIdAvailability(String id) {
        User existingUser = userRepository.findByUserId(id);
        return existingUser == null;
    }
}
