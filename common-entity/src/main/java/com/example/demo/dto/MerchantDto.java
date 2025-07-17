package com.example.demo.dto;

import com.example.demo.entity.Merchant;
import com.example.demo.enumeration.MerchantStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MerchantDto {

  private Long id;

  private String name;

  private String code;

  private MerchantStatus status;

  private Merchant parent;

  private Integer hierarchyLevel;

  private List<Merchant> children;
}
