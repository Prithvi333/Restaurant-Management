package com.restaurant.restaurant.controller;

import com.restaurant.restaurant.entity.Restaurant;
import com.restaurant.restaurant.service.restaurant.RestaurantDto;
import com.restaurant.restaurant.service.restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/create")
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant){
        return new ResponseEntity<>(restaurantService.createRestaurant(restaurant), HttpStatus.CREATED);
    }

    @GetMapping("/read")
    public ResponseEntity<List<Restaurant>> getAllRestaurant(){
        return new ResponseEntity<>(restaurantService.getAllRestaurant(),HttpStatus.OK);
    }

    @PatchMapping("/update/{restaurantId}")
    public  ResponseEntity<Restaurant> updateRestaurant(@PathVariable("restaurantId") int id, @RequestBody RestaurantDto restaurantDto){
        return new ResponseEntity<>(restaurantService.updateRestaurant(id,restaurantDto),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{restaurantId}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable("restaurantId") int id){
        return new ResponseEntity<>(restaurantService.deleteRestaurant(id),HttpStatus.OK);
    }

}
