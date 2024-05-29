package com.restaurant.restaurant.controller;

import com.restaurant.restaurant.entity.OrderItem;
import com.restaurant.restaurant.utility.OrderItemDto;
import com.restaurant.restaurant.service.order_item.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

  @PostMapping("/create/{orderId}/{menuItemId}")
    public ResponseEntity<OrderItem> createOrderItem(@PathVariable int orderId , @PathVariable int menuItemId, @RequestBody OrderItem orderItem){
      return new ResponseEntity<>(orderItemService.createOrderItem(orderId,menuItemId,orderItem), HttpStatus.OK);
  }
  @GetMapping("/read/{userId}")
    public ResponseEntity<List<OrderItem>> getAllOrderItem(@PathVariable int userId){
      return new ResponseEntity<>(orderItemService.getAllOrderItem(userId),HttpStatus.OK);
  }
  @DeleteMapping("/delete/{userId}/{orderId}")
    public ResponseEntity<String> deleteOrderItem(@PathVariable int userId, @PathVariable int orderId){
      return new ResponseEntity<>(orderItemService.deleteOrderItem(userId,orderId),HttpStatus.OK);
  }

  @PatchMapping("/update/{userId}/{orderId}")
    public ResponseEntity<OrderItem> updateOrderItem(@PathVariable int userId, @PathVariable int orderId, @RequestBody OrderItemDto orderItemDto){
      OrderItem orderItem = orderItemService.updateOrderItem(userId,orderId,orderItemDto);
      return new ResponseEntity<>(orderItem,HttpStatus.OK);
  }


}
