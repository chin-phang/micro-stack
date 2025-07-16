package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TenantDto {

  private Long tenantId;

  private String tenantName;

  private String tenantCode;

  private Long parentTenantId;

  private Integer hierarchyLevel;
}
