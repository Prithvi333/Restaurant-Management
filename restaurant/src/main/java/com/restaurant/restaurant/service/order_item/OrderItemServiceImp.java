package com.restaurant.restaurant.service.order_item;

import com.restaurant.restaurant.entity.MenuItem;
import com.restaurant.restaurant.entity.Order;
import com.restaurant.restaurant.entity.OrderItem;
import com.restaurant.restaurant.exception.itemex.MenuItemNotFound;
import com.restaurant.restaurant.exception.orderex.OrderNotFound;
import com.restaurant.restaurant.repository.MenuItemRepo;
import com.restaurant.restaurant.repository.OrderItemRepo;
import com.restaurant.restaurant.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderItemServiceImp implements OrderItemService{

    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private MenuItemRepo menuItemRepo;

    @Autowired
    private OrderItemRepo orderItemRepo;

    @Override
    public OrderItem createOrderItem(int orderId, int menuItemId,OrderItem orderItem) {

        Optional<Order> order = orderRepo.findById(orderId);
          if(order.isEmpty())
              throw new OrderNotFound();

          Optional<MenuItem> menuItem = menuItemRepo.findById(menuItemId);
          if(menuItem.isEmpty())
              throw new MenuItemNotFound();

          orderItem.setOrder(order.get());
          orderItem.setMenuItem(menuItem.get());

          orderRepo.save(order.get());
          menuItemRepo.save(menuItem.get());

          return orderItemRepo.findById(orderItem.getOrderItemId()).get();I

    }
}
