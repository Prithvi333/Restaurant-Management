package com.restaurant.restaurant.exception.userex;

public class EmptyUserList extends RuntimeException{
    public EmptyUserList(){
        super("Empty user list");
    }
    public  EmptyUserList(String message){
        super(message);
    }
}
