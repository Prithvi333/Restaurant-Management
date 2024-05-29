package com.restaurant.restaurant.service.order_item;

import com.restaurant.restaurant.entity.*;
import com.restaurant.restaurant.exception.itemex.MenuItemNotFound;
import com.restaurant.restaurant.exception.order_itemex.EmptyOrderItem;
import com.restaurant.restaurant.exception.order_itemex.OrderItemNotFound;
import com.restaurant.restaurant.exception.orderex.EmptyOrderList;
import com.restaurant.restaurant.exception.orderex.OrderNotFound;
import com.restaurant.restaurant.exception.userex.UserNotFound;
import com.restaurant.restaurant.repository.MenuItemRepo;
import com.restaurant.restaurant.repository.OrderItemRepo;
import com.restaurant.restaurant.repository.OrderRepo;
import com.restaurant.restaurant.repository.UserRepo;
import com.restaurant.restaurant.utility.OrderItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderItemServiceImp implements OrderItemService {

    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private MenuItemRepo menuItemRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private OrderItemRepo orderItemRepo;


    @Override
    public OrderItem createOrderItem(int orderId, int menuItemId, OrderItem orderItem) {

        Optional<Order> order = orderRepo.findById(orderId);
        if (order.isEmpty())
            throw new OrderNotFound();

        Optional<MenuItem> menuItem = menuItemRepo.findById(menuItemId);
        if (menuItem.isEmpty())
            throw new MenuItemNotFound();

        orderItem.setOrder(order.get());
        orderItem.setMenuItem(menuItem.get());
        return orderItemRepo.save(orderItem);

    }

    @Override
    public List<OrderItem> getAllOrderItem(int userId) {
        List<Order> orderList = orderRepo.findAll();
        List<OrderItem> ansList = new ArrayList<>();
        if (orderList.isEmpty())
            throw new EmptyOrderList();
        for (Order order : orderList) {
            if (order.getUser().getUserId() == userId) {
                List<OrderItem> orderItemList = order.getOrderItems();
                ansList.addAll(orderItemList);
            }

        }
        if (ansList.isEmpty())
            throw new EmptyOrderItem();
        return ansList;

    }

    @Override
    public String deleteOrderItem(int userId, int orderId) {
        Optional<User> user = userRepo.findById(userId);

        if(user.isEmpty())
            throw new UserNotFound();

        List<Order> orderList =  orderRepo.findAll();
        if(orderList.isEmpty())
            throw new EmptyOrderList();

        Optional<Order> itemOrder = orderRepo.findById(orderId);
         if(itemOrder.isEmpty())
             throw new OrderNotFound();

        boolean isOrderItemPresent = false;

        for(Order order : orderList){
            if(order.getUser().getUserId() == userId) {
                List<OrderItem> orderItemList = order.getOrderItems();
                for (int i = 0; i < orderItemList.size(); i++) {
                       OrderItem orderItem = orderItemList.get(i);
                       if(orderItem.getOrderItemId() == orderId){
                           isOrderItemPresent =true;
                           orderItemList.remove(orderId);
                           orderRepo.save(order);
                           break;
                       }
                }

            }
            if(isOrderItemPresent)
                break;
        }
        if(!isOrderItemPresent)
            throw new OrderItemNotFound();
        return "OrderItem with id "+orderId+" deleted successfully";
    }

    @Override
    public OrderItem updateOrderItem(int userId, int orderId, OrderItemDto orderItemDto) {

        Optional<User> user = userRepo.findById(userId);

        if(user.isEmpty())
            throw new UserNotFound();

        List<Order> orderList =  orderRepo.findAll();
        if(orderList.isEmpty())
            throw new EmptyOrderList();

        Optional<Order> itemOrder = orderRepo.findById(orderId);
        if(itemOrder.isEmpty())
            throw new OrderNotFound();

        boolean isOrderItemPresent = false;

        for(Order order : orderList){
            if(order.getUser().getUserId() == userId) {
                List<OrderItem> orderItemList = order.getOrderItems();
                for (int i = 0; i < orderItemList.size(); i++) {
                    OrderItem orderItem = orderItemList.get(i);
                    if(orderItem.getOrderItemId() == orderId){
                        isOrderItemPresent =true;
                        orderItem.setQuantity(orderItemDto.getQuantity());
                        orderItem.setSpecialRequest(orderItemDto.specialRequest);
                        orderRepo.save(order);
                        break;
                    }
                }

            }
            if(isOrderItemPresent)
                break;
        }

        if(!isOrderItemPresent)
            throw new OrderItemNotFound();
        return orderItemRepo.findById(orderId).get();

    }
}
