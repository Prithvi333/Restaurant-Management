package com.restaurant.restaurant.exception.adminex;

import com.restaurant.restaurant.exception.userex.EmptyUserList;

public class EmptyAdminList extends  RuntimeException{

    public  EmptyAdminList(){
        super("Empty admin list found");
    }
    public  EmptyAdminList(String message){
        super(message);
    }

}
