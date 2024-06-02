package com.example.demo.service;


import com.example.demo.Entity.MenuCategory;
import com.example.demo.Entity.Restaurant;
import com.example.demo.Entity.User;
import com.example.demo.repository.MenuCategoryRepository;
import com.example.demo.repository.RestaurantRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuCategoryRepository menuCategoryRepository;
    @Autowired
    private UserRepository userRepository;

    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(String id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    public void deleteRestaurant(String id) {
        restaurantRepository.deleteById(id);
    }

    public void addLiker(String restaurantId, String userId) {
        Optional<Restaurant> restaurantOpt = restaurantRepository.findById(restaurantId);
        if (restaurantOpt.isPresent()) {
            Restaurant restaurant = restaurantOpt.get();
            restaurant.addLiker(userId);
            restaurantRepository.save(restaurant);

            Optional<User> userOpt = userRepository.findById(userId);
            if (userOpt.isPresent()){
                User user = userOpt.get();
                user.addLikedRestaurantId(restaurantId);
                userRepository.save(user);
            }

        }
    }
    public void removeLiker(String restaurantId, String userId) {
        Optional<Restaurant> restaurantOpt = restaurantRepository.findById(restaurantId);
        if (restaurantOpt.isPresent()) {
            Restaurant restaurant = restaurantOpt.get();
            restaurant.removeLiker(userId);
            restaurantRepository.save(restaurant);

            Optional<User> userOpt = userRepository.findById(userId);
            if (userOpt.isPresent()){
                User user = userOpt.get();
            user.removeLikedRestaurantId(restaurantId);
            userRepository.save(user);
        }
    }
    }
    public void addRestaurantToMenuCategory(String categoryId, String restaurantId, String restaurantName) {
        MenuCategory menuCategory = menuCategoryRepository.findById(categoryId).orElse(null);
        if (menuCategory != null) {
            MenuCategory.RestaurantInfo restaurantInfo = new MenuCategory.RestaurantInfo(restaurantId, restaurantName);
            menuCategory.getRestaurantInfoList().add(restaurantInfo);
            menuCategoryRepository.save(menuCategory);
        }
    }
}
