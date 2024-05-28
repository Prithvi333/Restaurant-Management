package com.restaurant.restaurant.exception.restaurantex;

import com.restaurant.restaurant.entity.Restaurant;

public class RestaurantNotFound extends  RuntimeException {

      public  RestaurantNotFound(){
          super("Restaurant not found");
      }
      public  RestaurantNotFound(String message){
          super(message);
      }
}
