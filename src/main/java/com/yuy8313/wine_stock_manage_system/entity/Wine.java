package com.yuy8313.wine_stock_manage_system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Wine extends BaseEntity{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "wine_id")
  private int wineId;

  @Column(name = "wine_name")
  private String wineName;

  @Column(name = "wine_type")
  private String wineType;

  @Column(name = "country")
  private String country;

  @Column(name = "wine_price")
  private int winePrice;

}
