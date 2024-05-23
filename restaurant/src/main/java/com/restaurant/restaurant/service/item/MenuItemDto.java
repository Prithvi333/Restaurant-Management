package com.restaurant.restaurant.service.item;

public class MenuItemDto {
    int price;
    String category;

    public MenuItemDto(){
        super();
    }

    public MenuItemDto(int price, String category) {
        this.price = price;
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
