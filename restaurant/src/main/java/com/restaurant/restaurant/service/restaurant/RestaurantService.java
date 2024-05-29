package com.restaurant.restaurant.service.restaurant;

import com.restaurant.restaurant.entity.Restaurant;
import com.restaurant.restaurant.utility.RestaurantDto;

import java.util.List;

public interface RestaurantService {
    Restaurant createRestaurant(Restaurant restaurant);
    List<Restaurant> getAllRestaurant();
    Restaurant updateRestaurant(int restaurantId, RestaurantDto restaurantDto);
    String deleteRestaurant(int restaurantId);
}
