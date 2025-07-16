package com.example.demo.enumeration;

import lombok.Getter;

@Getter
public enum UserStatus {

  ACTIVE {
    @Override
    public boolean isActive() {
      return true;
    }
  },
  INACTIVE {
    @Override
    public boolean isInactive() {
      return true;
    }
  };

  public boolean isActive() {
    return false;
  }

  public boolean isInactive() {
    return false;
  }
}
