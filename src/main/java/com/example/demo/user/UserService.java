package com.example.demo.user;



public interface UserService  {

    User registerNewUserAccount(User user) throws EmailExistsException, UsernameExistsException;

}
