package com.restaurant.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Customer_Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int orderId;

    @ManyToOne
    @JsonIgnore
    User user;

    @Temporal(TemporalType.TIME)
    LocalTime localTime;
    boolean status;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy ="order" , orphanRemoval = true)
    List<OrderItem> orderItems = new ArrayList<>();

    public Order(){
        super();
    }

    public Order(List<OrderItem> orderItems, boolean status, LocalTime localTime, User user) {
        this.orderItems = orderItems;
        this.status = status;
        this.localTime = localTime;
        this.user = user;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public int getOrderId() {
        return orderId;
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
