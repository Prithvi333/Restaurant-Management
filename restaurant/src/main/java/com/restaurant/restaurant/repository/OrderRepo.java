package com.restaurant.restaurant.repository;

import com.restaurant.restaurant.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Integer> {
}
