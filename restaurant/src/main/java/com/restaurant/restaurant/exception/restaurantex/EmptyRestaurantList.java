package com.restaurant.restaurant.exception.restaurantex;

public class EmptyRestaurantList extends  RuntimeException{
    public EmptyRestaurantList(){
        super("Empty restaurant list");
    }
    public EmptyRestaurantList(String message){
        super(message);
    }
}
