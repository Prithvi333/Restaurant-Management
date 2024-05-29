package com.restaurant.restaurant.utility;

public class MenuDto {
    String name;
    String description;

    public MenuDto(String name,String description){
        this.name =name;
        this.description =description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
