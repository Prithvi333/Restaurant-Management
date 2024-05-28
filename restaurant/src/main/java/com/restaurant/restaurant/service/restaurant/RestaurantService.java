package com.restaurant.restaurant.service.restaurant;

import com.restaurant.restaurant.entity.Restaurant;

import java.util.List;

public interface RestaurantService {
    Restaurant createRestaurant(Restaurant restaurant);
    List<Restaurant> getAllRestaurant();
    Restaurant updateRestaurant(int restaurantId,RestaurantDto restaurantDto);
    String deleteRestaurant(int restaurantId);
}
