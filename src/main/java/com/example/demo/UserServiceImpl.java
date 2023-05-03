package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public User registerNewUserAccount(UserDto userDto) throws EmailExistsException, UsernameExistsException {
        if (userRepository.findByUsername(userDto.getUsername()) != null) {
            throw new UsernameExistsException("Username already exists: " + userDto.getUsername());
        }
        User user = new User(userDto.getUsername(),userDto.getId(), userDto.getPassword());
        return userRepository.save(user);
    }


}

