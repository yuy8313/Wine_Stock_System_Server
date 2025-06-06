package com.yuy8313.wine_stock_manage_system.controller;

import java.util.Collection;
import java.util.Iterator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @GetMapping("/")
  public String mainPage(Model model) {
    String id = SecurityContextHolder.getContext().getAuthentication().getName();

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
    Iterator<? extends GrantedAuthority> iter = authorities.iterator();
    GrantedAuthority auth = iter.next();
    String role = auth.getAuthority();

    model.addAttribute("id", id);
    model.addAttribute("role", role);
    return "main";
  }
}
