package com.restaurant.restaurant.service.menu;

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
