package com.yuy8313.wine_stock_manage_system.service;

import com.yuy8313.wine_stock_manage_system.dto.JoinDTO;
import com.yuy8313.wine_stock_manage_system.entity.User;
import com.yuy8313.wine_stock_manage_system.repository.UserRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

  private UserRepository userRepository;

  private BCryptPasswordEncoder bCryptPasswordEncoder;

  public JoinService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userRepository = userRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  public void joinProcess(JoinDTO joinDTO) {
    boolean isUser = userRepository.existsByUsername(joinDTO.getUsername());

    if (isUser) {
      throw new IllegalArgumentException("이미 존재하는 아이디 입니다.");
    }

    User user = new User();

    user.setUsername(joinDTO.getUsername());
    user.setPassword(bCryptPasswordEncoder.encode(joinDTO.getPassword()));
    user.setRole("ROLE_USER");

    user.setRegDate(LocalDateTime.now());
    user.setDeleteFlag(false);

    userRepository.save(user);
  }
}
