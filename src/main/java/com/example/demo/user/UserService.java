package com.example.demo.user;



public interface UserService  {

    User registerNewUserAccount(UserDto userDto) throws EmailExistsException, UsernameExistsException;

}
