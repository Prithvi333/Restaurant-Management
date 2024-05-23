package com.restaurant.restaurant.exception.orderex;

public class OrderNotFound extends  RuntimeException{
    public OrderNotFound(){
        super("Order not found");
    }
    public OrderNotFound(String message){
        super(message);
    }
}
