package com.restaurant.restaurant.repository;

import com.restaurant.restaurant.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> {
    public Optional<User> findByEmail(String email);
}
