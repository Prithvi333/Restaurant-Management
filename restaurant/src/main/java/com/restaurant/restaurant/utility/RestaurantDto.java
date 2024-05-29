package com.restaurant.restaurant.utility;

public class RestaurantDto {
    int seatingCapacity;
    String location;

    public RestaurantDto(int seatingCapacity, String location) {
        this.seatingCapacity = seatingCapacity;
        this.location = location;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
