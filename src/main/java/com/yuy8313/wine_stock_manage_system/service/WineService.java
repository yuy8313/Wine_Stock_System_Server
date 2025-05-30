package com.yuy8313.wine_stock_manage_system.service;

import com.yuy8313.wine_stock_manage_system.dto.WineDTO;
import com.yuy8313.wine_stock_manage_system.entity.Wine;
import com.yuy8313.wine_stock_manage_system.repository.WineRepository;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class WineService {

  private final WineRepository wineRepository;

  public WineService(WineRepository wineRepository) {
    this.wineRepository = wineRepository;
  }

  public void registerWine(WineDTO wineDTO, int userId) {
    Wine wine = new Wine();

    wine.setWineName(wineDTO.getWineName());
    wine.setWineType(wineDTO.getWineType());
    wine.setCountry(wineDTO.getCountry());
    wine.setWinePrice(wineDTO.getWinePrice());

    wine.setRegUserId(userId);
    wine.setRegDate(LocalDateTime.now());
    wine.setDeleteFlag(false);

    wineRepository.save(wine);
  }
}
