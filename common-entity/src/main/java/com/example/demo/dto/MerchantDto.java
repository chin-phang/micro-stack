package com.example.demo.dto;

import com.example.demo.entity.Merchant;
import com.example.demo.enumeration.MerchantStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MerchantDto extends  BaseDto {

  private Long id;

  private String name;

  private String code;

  private MerchantStatus status;

  private Merchant parent;

  private Integer hierarchyLevel;

  private List<Merchant> children;
}
