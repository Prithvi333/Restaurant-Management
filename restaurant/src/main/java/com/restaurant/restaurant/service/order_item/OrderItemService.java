package com.restaurant.restaurant.service.order_item;

import com.restaurant.restaurant.entity.OrderItem;
import com.restaurant.restaurant.repository.OrderItemRepo;

import java.util.List;

public interface OrderItemService {

    public OrderItem createOrderItem(int orderId, int menuItemId, OrderItem orderItem);

    public List<OrderItem> getAllOrderItem(int userId);


}
