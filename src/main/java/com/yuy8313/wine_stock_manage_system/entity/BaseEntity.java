package com.yuy8313.wine_stock_manage_system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

  @Column(name = "reg_date")
  private LocalDateTime regDate;
  @Column(name = "reg_user_id")
  private int regUserId;

  @Column(name = "update_date")
  private LocalDateTime updateDate;

  @Column(name = "update_user_id")
  private int updateUserId;

  @Column(name = "delete_flag")
  private boolean deleteFlag;

  @PrePersist
  public void prePersist() {
    this.regDate = LocalDateTime.now();
    this.deleteFlag = false;
  }

  @PreUpdate
  public void preUpdate() {
    this.updateDate = LocalDateTime.now();
  }
}
