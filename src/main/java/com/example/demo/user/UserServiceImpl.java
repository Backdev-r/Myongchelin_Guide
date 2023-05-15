package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public User registerNewUserAccount(UserDto userDto) throws EmailExistsException, UsernameExistsException {
        if (userRepository.findByUsername(userDto.getUsername()) != null) {
            throw new UsernameExistsException("Username already exists: " + userDto.getUsername());
        }
        User user = new User(userDto.getEmail(), userDto.getCerNum(), userDto.getUsername(),userDto.getId(), userDto.getPassword());
        return userRepository.save(user);
    }





}

