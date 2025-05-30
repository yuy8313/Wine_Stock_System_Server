package com.yuy8313.wine_stock_manage_system.service;

import com.yuy8313.wine_stock_manage_system.dto.WineDTO;
import com.yuy8313.wine_stock_manage_system.entity.Wine;
import com.yuy8313.wine_stock_manage_system.repository.WineRepository;
import java.time.LocalDateTime;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

  public void updateWine(int wineId, Wine updatedWine, int userId) {
    Wine wine = wineRepository.findById(wineId).orElseThrow();
    wine.setWineName(updatedWine.getWineName());
    wine.setWineType(updatedWine.getWineType());
    wine.setCountry(updatedWine.getCountry());
    wine.setWinePrice(updatedWine.getWinePrice());
    wine.setUpdateUserId(userId);
    wineRepository.save(wine);
  }

  public void deleteWine(int wineId, int userId) {
    Wine wine = wineRepository.findById(wineId)
        .orElseThrow(() -> new IllegalArgumentException("존재하지않는 와인입니다."));
    wine.setDeleteFlag(true);
    wine.setUpdateUserId(userId);
    wineRepository.save(wine);
  }
}
