package com.yuy8313.wine_stock_manage_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WineDTO {
  private String wineName;
  private String wineType;
  private String country;
  private int winePrice;
}
