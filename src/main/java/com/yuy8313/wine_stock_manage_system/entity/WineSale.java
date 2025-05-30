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
public class WineSale extends BaseEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "wine_sale_id")
  private int wineSaleId;

  @Column(name = "wine_id")
  private int wineId;

  @Column(name = "wine_sale_qty")
  private int wineSaleQty;

  @Column(name = "sold_date")
  private LocalDateTime soldDate;
}
