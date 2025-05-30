package com.yuy8313.wine_stock_manage_system.repository;

import com.yuy8313.wine_stock_manage_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

  boolean existsByUsername(String username);

  User findByUsername(String username);
}
