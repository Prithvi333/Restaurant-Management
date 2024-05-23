package com.restaurant.restaurant.service.order;

import java.time.LocalTime;

public class OrderDto {

    boolean status;

    public OrderDto(){
        super();
    }
    public OrderDto(  boolean status) {

        this.status = status;
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
