package com.example.demo.service;


import com.example.demo.Entity.Restaurant;
import com.example.demo.Entity.User;

import java.util.List;

public interface UserService {

    User registerNewUserAccount(User user);

    boolean checkNicknameAvailability(String username);

    boolean checkUserIdAvailability(String id);

    List<Restaurant> getLikedRestaurants(String username);
}
