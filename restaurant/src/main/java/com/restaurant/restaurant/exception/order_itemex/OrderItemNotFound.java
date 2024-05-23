package com.restaurant.restaurant.exception.order_itemex;

public class OrderItemNotFound extends  RuntimeException{
    public OrderItemNotFound(){
        super("OrderItem not found");
    }
    public OrderItemNotFound(String message){
        super(message);
    }
}
