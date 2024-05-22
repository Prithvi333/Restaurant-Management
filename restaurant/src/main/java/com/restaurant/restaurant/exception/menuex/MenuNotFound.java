package com.restaurant.restaurant.exception.menuex;

import com.restaurant.restaurant.entity.Menu;

public class MenuNotFound extends  RuntimeException{
            public MenuNotFound(){super("Menu not found");};
            public MenuNotFound(String message){
                super(message);
            }
}
