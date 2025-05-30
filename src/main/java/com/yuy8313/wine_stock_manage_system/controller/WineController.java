package com.yuy8313.wine_stock_manage_system.controller;

import com.yuy8313.wine_stock_manage_system.dto.WineDTO;
import com.yuy8313.wine_stock_manage_system.service.WineService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wines")
public class WineController {
  private WineService wineService;

  public WineController(WineService wineService) {
    this.wineService = wineService;
  }

  @GetMapping("/new")
  public String showWineForm(Model model) {
    model.addAttribute("wineDTO", new WineDTO());
    return "wines/new";
  }

  @PostMapping
  public String registerWine(@ModelAttribute WineDTO wineDTO) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String username = auth.getName();

    int userId = 1;

    wineService.registerWine(wineDTO, userId);
    return "redirect:/wines";
  }
}
