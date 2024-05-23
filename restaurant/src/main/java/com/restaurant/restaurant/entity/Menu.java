package com.restaurant.restaurant.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int menuId;
    String name;
    String description;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "menu",orphanRemoval = true)
    List<MenuItem> menuItems  = new ArrayList<>();
    public Menu(){
        super();
    }

    public Menu(  String description, String name,List<MenuItem> menuItems) {
        this.description = description;
        this.name = name;
        this.menuItems = menuItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public int getMenuId() {
        return menuId;
    }
}
