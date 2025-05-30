package com.yuy8313.wine_stock_manage_system.controller;

import com.yuy8313.wine_stock_manage_system.dto.CustomUserDetails;
import com.yuy8313.wine_stock_manage_system.dto.WineDTO;
import com.yuy8313.wine_stock_manage_system.entity.Wine;
import com.yuy8313.wine_stock_manage_system.repository.WineRepository;
import com.yuy8313.wine_stock_manage_system.service.WineService;
import java.util.List;
import org.springframework.boot.Banner.Mode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wines")
public class WineController {
  private WineService wineService;

  private WineRepository wineRepository;

  public WineController(WineService wineService, WineRepository wineRepository) {
    this.wineService = wineService;
    this.wineRepository = wineRepository;
  }

  @GetMapping("/new")
  public String showWineForm(Model model) {
    model.addAttribute("wineDTO", new WineDTO());
    return "wines/new";
  }

  @PostMapping
  public String registerWine(@ModelAttribute WineDTO wineDTO) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    Object principal = auth.getPrincipal();
    int userId = userId = ((CustomUserDetails) principal).getUserId();

    wineService.registerWine(wineDTO, userId);
    return "redirect:/wines";
  }

  @GetMapping
  public String listWines(Model model) {
    List<Wine> wines = wineRepository.findByDeleteFlagFalse();
    model.addAttribute("wines", wines);
    return "wines/list";
  }

  @GetMapping("/{wineId}/edit")
  public String showEditForm(@PathVariable int wineId, Model model) {
    Wine wine = wineRepository.findById(wineId).get();
    model.addAttribute("wine", wine);

    return "wines/edit";
  }
  @PostMapping("/{wineId}/edit")
  public String editWine(@PathVariable int wineId, @ModelAttribute Wine wine) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    Object principal = auth.getPrincipal();
    int userId = userId = ((CustomUserDetails) principal).getUserId();

    wineService.updateWine(wineId, wine, userId);

    return "redirect:/wines";
  }

  @PostMapping("/{wineId}/delete")
  public String deleteWine(@PathVariable int wineId) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    Object principal = auth.getPrincipal();
    int userId = userId = ((CustomUserDetails) principal).getUserId();
    wineService.deleteWine(wineId, userId);

    return "redirect:/wines";
  }
}
