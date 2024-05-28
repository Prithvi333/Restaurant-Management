package com.restaurant.restaurant.entity;

import jakarta.persistence.*;
import org.springframework.data.repository.cdi.Eager;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int restaurantId;
    int seatingCapacity;
    String location;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "restaurant")
    Menu menu;
      public  Restaurant(){

      }
    public Restaurant(Menu menu, String location, int seatingCapacity) {
        this.menu = menu;
        this.location = location;
        this.seatingCapacity = seatingCapacity;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }
}
