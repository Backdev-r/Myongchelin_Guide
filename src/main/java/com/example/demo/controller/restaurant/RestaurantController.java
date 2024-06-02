package com.example.demo.controller.restaurant;

import com.example.demo.Entity.Like;
import com.example.demo.dto.user.LikeListClass;
import com.example.demo.dto.user.UserLike;
import com.example.demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @CrossOrigin(origins = "*")
    @PostMapping("/{restaurantId}/like")
    public ResponseEntity<String> likeRestaurant(@PathVariable String restaurantId, @RequestBody UserLike userLike) {
        restaurantService.addLiker(restaurantId, userLike.getUserId());
        return ResponseEntity.ok("찜 등록 완료");
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/{restaurantId}/unlike")
    public ResponseEntity<String> unlikeRestaurant(@PathVariable String restaurantId, @RequestBody UserLike userLike) {
        restaurantService.removeLiker(restaurantId, userLike.getUserId());
        return ResponseEntity.ok("찜 해제 완료");
    }


}