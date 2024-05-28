package com.restaurant.restaurant.service.order;

import com.restaurant.restaurant.entity.Order;

import java.util.List;

public interface OrderService {
    public String createOrder(int userId);
    public List<Order> getAllOrder(int userId);
    String deleteOrder(int userId,int orderId);
    Order updateOrder(int userId,int orderId,OrderDto orderDto);
}
