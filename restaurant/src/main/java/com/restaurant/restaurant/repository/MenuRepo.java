package com.restaurant.restaurant.repository;

import com.restaurant.restaurant.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepo extends JpaRepository<Menu,Integer> {
}
