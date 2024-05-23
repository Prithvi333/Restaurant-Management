package com.restaurant.restaurant.repository;
import com.restaurant.restaurant.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuItemRepo extends JpaRepository<MenuItem,Integer> {
    Optional<MenuItem> findByName(String name);

}
