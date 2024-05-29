package com.restaurant.restaurant.service.order_item;

import com.restaurant.restaurant.entity.OrderItem;
import com.restaurant.restaurant.utility.OrderItemDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OrderItemService {

    public OrderItem createOrderItem(int orderId, int menuItemId, OrderItem orderItem);

    public List<OrderItem> getAllOrderItem(int userId);

    public String deleteOrderItem(int userId,int orderId);

    public OrderItem updateOrderItem(int userId, int orderId, @RequestBody OrderItemDto orderItemDto);

}
