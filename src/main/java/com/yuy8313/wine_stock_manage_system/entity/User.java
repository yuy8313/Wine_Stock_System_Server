package com.yuy8313.wine_stock_manage_system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "user_name", unique = true)
  private String username;

  @Column(name = "user_password")
  private String password;

  @Column(name = "user_role")
  private String role;

  @Column(name = "reg_date")
  private LocalDateTime regDate;

  @Column(name = "update_date")
  private LocalDateTime updateDate;

  @Column(name = "delete_flag")
  private boolean deleteFlag;
}
