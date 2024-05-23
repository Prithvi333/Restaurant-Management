package com.restaurant.restaurant.exception.itemex;

public class EmptyMenuItem  extends  RuntimeException{

    public EmptyMenuItem(){
        super("Empty menu item");
    }
    public EmptyMenuItem(String message){
        super(message);
    }
}
