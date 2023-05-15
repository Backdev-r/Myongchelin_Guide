package com.example.demo;



public interface UserService  {

    User registerNewUserAccount(UserDto userDto) throws EmailExistsException, UsernameExistsException;

}
