package com.yuy8313.wine_stock_manage_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
  
  @GetMapping("/admin")
  public String adminPage() {
    return "admin";
  }
}
