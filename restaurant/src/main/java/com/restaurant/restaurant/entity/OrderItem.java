package com.restaurant.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    int orderItemId;
    int quantity;
    boolean specialRequest;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    Order order;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    MenuItem menuItem;

    public OrderItem(){
        super();
    }

    public OrderItem(int quantity, boolean specialRequest, Order order, MenuItem menuItem) {
        this.quantity = quantity;
        this.specialRequest = specialRequest;
        this.order = order;
        this.menuItem = menuItem;
    }

    public int getOrderItemId() {
        return orderItemId;
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

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
