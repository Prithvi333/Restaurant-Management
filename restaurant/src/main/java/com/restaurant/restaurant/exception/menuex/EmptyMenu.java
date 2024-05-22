package com.restaurant.restaurant.exception.menuex;

public class EmptyMenu extends  RuntimeException {
    public EmptyMenu(){
        super("Menu is empty");
    }
    public EmptyMenu(String message){super(message);}
}
