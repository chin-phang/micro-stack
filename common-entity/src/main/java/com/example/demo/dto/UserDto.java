package com.example.demo.dto;

import com.example.demo.enumeration.UserStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends BaseDto {

  private Long id;

  private String username;

  private String password;

  private UserStatus status;

  private List<AccountDto> accounts;

  private List<RoleDto> roles;
}
