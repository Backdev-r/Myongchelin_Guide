package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public User registerNewUserAccount(User user) throws  UsernameExistsException {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            System.out.println(user.getUsername() + user.getEmail()+user.getPassword());
            throw new UsernameExistsException("Username already exists :" + user.getUsername() );
        }
        User user1 = new User(user.getEmail(), user.getCerNum(), user.getUsername(),user.getId(), user.getPassword());
        return userRepository.save(user1);
    }





}

