package com.example.demo.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "MenuCategory")
public class MenuCategory {
    @Id
    private String id;
    private String name;
    private List<RestaurantInfo> restaurantInfoList;

    public MenuCategory() {
    }


    @Data
    @AllArgsConstructor
    public static class RestaurantInfo {
        private String restaurant_id;
        private String restaurant_name;


        public RestaurantInfo() {
        }


    }
}