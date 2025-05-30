package com.yuy8313.wine_stock_manage_system.service;

import com.yuy8313.wine_stock_manage_system.dto.CustomUserDetails;
import com.yuy8313.wine_stock_manage_system.entity.User;
import com.yuy8313.wine_stock_manage_system.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  public CustomUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);

    if (user != null) {
      return new CustomUserDetails(user);
    }
    return null;
  }
}
