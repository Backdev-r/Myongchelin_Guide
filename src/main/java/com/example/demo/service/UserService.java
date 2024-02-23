package com.example.demo.service;


import com.example.demo.document.User;

public interface UserService  {

    User registerNewUserAccount(User user);

    boolean checkNicknameAvailability(String username);

    boolean checkUserIdAvailability(String id);
}
