package com.restaurant.restaurant.exception.orderex;

public class EmptyOrderList extends RuntimeException {
    public EmptyOrderList(){
        super("Empty Order list found");
    }
    public EmptyOrderList(String message){
        super(message);
    }
}
