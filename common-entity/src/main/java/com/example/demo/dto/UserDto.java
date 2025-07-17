package com.example.demo.dto;

import com.example.demo.enumeration.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

  private Long id;

  private String username;

  private String password;

  private UserStatus status;

  private List<AccountDto> accounts;

  private List<RoleDto> roles;
}
