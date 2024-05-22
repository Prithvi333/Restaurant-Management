package com.restaurant.restaurant.repository;

import com.restaurant.restaurant.entity.Menu;
import com.restaurant.restaurant.service.item.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepo extends JpaRepository<Menu,Integer> {
}
