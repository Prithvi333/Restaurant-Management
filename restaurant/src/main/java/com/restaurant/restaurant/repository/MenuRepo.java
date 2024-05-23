package com.restaurant.restaurant.repository;

import com.restaurant.restaurant.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuRepo extends JpaRepository<Menu,Integer> {
    public Optional<Menu> findByNameAndMenuId(String menuName,int menuId);
}
