package com.restaurant.restaurant.controller;

import com.restaurant.restaurant.entity.OrderItem;
import com.restaurant.restaurant.service.order_item.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("orders")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

  @PostMapping("/create/{orderId}/{menuItemId}")
    public ResponseEntity<OrderItem> createOrderItem(@PathVariable int orderId , @PathVariable int menuItemId, @RequestBody OrderItem orderItem){
      return new ResponseEntity<>(orderItemService.createOrderItem(orderId,menuItemId,orderItem), HttpStatus.OK);
  }


}
