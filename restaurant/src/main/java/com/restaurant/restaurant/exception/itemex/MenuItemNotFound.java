package com.restaurant.restaurant.exception.itemex;

public class MenuItemNotFound extends  RuntimeException{
    public MenuItemNotFound(){
        super("MenuItem not found");
    }
    public MenuItemNotFound(String message){
        super(message);
    }
}
