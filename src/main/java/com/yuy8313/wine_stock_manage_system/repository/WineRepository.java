package com.yuy8313.wine_stock_manage_system.repository;

import com.yuy8313.wine_stock_manage_system.entity.Wine;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WineRepository extends JpaRepository<Wine, Integer> {
  List<Wine> findByDeleteFlagFalse();
}
