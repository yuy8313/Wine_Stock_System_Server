package com.yuy8313.wine_stock_manage_system.controller;

import com.yuy8313.wine_stock_manage_system.dto.JoinDTO;
import com.yuy8313.wine_stock_manage_system.service.JoinService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JoinController {

  private final JoinService joinService;

  public JoinController(JoinService joinService) {
    this.joinService = joinService;
  }

  @GetMapping("/join")
  public String joinPage() {
    return "join";
  }

  @PostMapping("/joinProc")
  public String joinProcess(JoinDTO joinDTO) {
    System.out.println(joinDTO.getUsername());
    joinService.joinProcess(joinDTO);
    return "redirect:/login";
  }
}
