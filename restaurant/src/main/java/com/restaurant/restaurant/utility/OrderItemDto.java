package com.restaurant.restaurant.utility;

public class OrderItemDto {
    int quantity;
    boolean specialRequest;

    public OrderItemDto(int quantity, boolean specialRequest) {
        this.quantity = quantity;
        this.specialRequest = specialRequest;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isSpecialRequest() {
        return specialRequest;
    }

    public void setSpecialRequest(boolean specialRequest) {
        this.specialRequest = specialRequest;
    }
}
