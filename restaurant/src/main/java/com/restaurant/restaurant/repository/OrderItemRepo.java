package com.restaurant.restaurant.repository;

import com.restaurant.restaurant.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<OrderItem,Integer> {
}
