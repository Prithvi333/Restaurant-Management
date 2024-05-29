package com.restaurant.restaurant.controller;

import com.restaurant.restaurant.entity.Order;
import com.restaurant.restaurant.utility.OrderDto;
import com.restaurant.restaurant.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create/{userId}")
    public ResponseEntity<Order> createOrder(@PathVariable int userId){
      return new ResponseEntity<>(orderService.createOrder(userId), HttpStatus.CREATED);
    }

    @GetMapping("/read/{userId}")
    public ResponseEntity<List<Order>> getAllOrder(@PathVariable("userId") int userId){
        return new ResponseEntity<>(orderService.getAllOrder(userId),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{userId}/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable int userId,@PathVariable int orderId){
        return new ResponseEntity<>(orderService.deleteOrder(userId,orderId),HttpStatus.OK);
    }

    @PatchMapping("/update/{userId}/{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable int userId , @PathVariable int orderId, @RequestBody OrderDto orderDto){
        return new ResponseEntity<>(orderService.updateOrder(userId,orderId,orderDto),HttpStatus.OK);
    }



}
