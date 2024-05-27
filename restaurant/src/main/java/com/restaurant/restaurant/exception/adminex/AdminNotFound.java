package com.restaurant.restaurant.exception.adminex;

public class AdminNotFound extends  RuntimeException{
    public AdminNotFound(){
        super("Admin not found");
    }
    public  AdminNotFound(String message){
        super(message);
    }
}
