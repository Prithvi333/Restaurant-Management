package com.restaurant.restaurant.repository;

import com.restaurant.restaurant.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admin,Integer> {
    public Optional<Admin> findByEmail(String email);
}
