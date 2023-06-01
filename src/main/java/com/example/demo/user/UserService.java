package com.example.demo.user;



public interface UserService  {

    User registerNewUserAccount(User user);

    boolean checkNicknameAvailability(String username);

    boolean checkUserIdAvailability(String id);
}
