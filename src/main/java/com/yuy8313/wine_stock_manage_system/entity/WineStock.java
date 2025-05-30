package com.yuy8313.wine_stock_manage_system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class WineStock extends BaseEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "stock_id")
  private int stockId;

  @Column(name = "wine_id")
  private int wineId;

  @Column(name = "wine_stock_qty")
  private int wineStockQty;

  @Column(name = "stock_date")
  private LocalDateTime stockDate;
}
