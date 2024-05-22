package com.restaurant.restaurant.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int menuItemId;
    String name;
    String description;
    int price;
    String category;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
     Menu menu;

    public MenuItem(String name, String description, int price, String category,Menu menu) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.menu = menu;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public boolean equals(Object obj) {
         MenuItem menuItem = (MenuItem) obj;
         if(this.name.equals(menuItem.name))
             return true;
         return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
