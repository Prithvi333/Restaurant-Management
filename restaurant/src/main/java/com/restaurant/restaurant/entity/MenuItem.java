package com.restaurant.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
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

    @ManyToOne
    @JsonIgnore
      Menu menu;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "menuItem",orphanRemoval = true)
    List<OrderItem> orderItems =  new ArrayList<>();

    public MenuItem(){
        super();
    }

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

    public int getMenuItemId() {
        return menuItemId;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return STR."MenuItem{menuItemId=\{menuItemId}, name='\{name}\{'\''}, description='\{description}\{'\''}, price=\{price}, category='\{category}\{'\''}, menu=\{menu}\{'}'}";
    }
}
