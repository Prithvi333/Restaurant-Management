package com.restaurant.restaurant.service.order;

import com.restaurant.restaurant.entity.Order;
import com.restaurant.restaurant.entity.User;
import com.restaurant.restaurant.exception.orderex.EmptyOrderList;
import com.restaurant.restaurant.exception.orderex.OrderNotFound;
import com.restaurant.restaurant.exception.userex.UserNotFound;
import com.restaurant.restaurant.repository.OrderRepo;
import com.restaurant.restaurant.repository.UserRepo;
import com.restaurant.restaurant.utility.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImp implements  OrderService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private OrderRepo orderRepo;

    @Override
    public Order createOrder(int userId) {

        Optional<User> user = userRepo.findById(userId);
        if(user.isEmpty())
         throw new UserNotFound("Customer not found with id "+userId);
        Order order =  new Order();
        order.setUser(user.get());
        order.setLocalTime(LocalTime.now());
        order.setStatus(true);
        user.get().getOrderList().add(order);
        userRepo.save(user.get());
        return order;
    }

    @Override
    public List<Order> getAllOrder(int userId) {
        Optional<User> user = userRepo.findById(userId);
         if(user.isEmpty())
             throw new UserNotFound();

       List<Order> orderList  =  user.get().getOrderList();
       if(orderList.isEmpty())
           throw new EmptyOrderList();
       else return orderList;
    }

    @Override
    public String deleteOrder(int userId, int orderId) {
        Optional<User> user = userRepo.findById(userId);
        if(user.isEmpty())
            throw new UserNotFound();
        List<Order> orderList  =  user.get().getOrderList();
        if(orderList.isEmpty())
            throw new EmptyOrderList();
        List<Order> ordersList= user.get().getOrderList().stream().filter(order->order.getOrderId()!=orderId).collect(Collectors.toList());
        user.get().setOrderList(ordersList);
        userRepo.save(user.get());
        return "Order with id "+orderId+" deleted successfully";
    }

    @Override
    public Order updateOrder(int userId, int orderId, OrderDto orderDto) {

        Optional<User> user = userRepo.findById(userId);
        if(user.isEmpty()) throw  new UserNotFound();

        List<Order> orderList = user.get().getOrderList();
        boolean isOrderPresent = false;
        for(Order order : orderList){
            if(order.getOrderId() == orderId){
                isOrderPresent=true;
                order.setLocalTime(LocalTime.now());
                order.setStatus(order.isStatus());
            }
        }
        if(!isOrderPresent){
           throw new OrderNotFound();
        }
        return orderRepo.findById(orderId).get();
    }
}
