package com.restaurant.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.security.AlgorithmConstraints;
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
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "menuItem", orphanRemoval = true)
    List<OrderItem> orderItems =  new ArrayList<>();

    public MenuItem(){
        super();
    }

    public MenuItem(String name, String description, int price, String category,Menu menu,List<OrderItem> orderItems) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.menu = menu;
        this.orderItems = orderItems;
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


    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }


}
