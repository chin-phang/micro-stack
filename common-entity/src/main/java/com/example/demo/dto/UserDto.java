package com.example.demo.dto;

import com.example.demo.entity.AccountProfile;
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

  private Long userId;

  private String username;

  private String password;

  private List<RoleDto> roles;

  private Long userInfoId;

  private Long tenantId;

  private AccountProfile accountProfile;

  private TenantDto tenant;
}
