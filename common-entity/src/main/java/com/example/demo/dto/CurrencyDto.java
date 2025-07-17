package com.example.demo.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyDto {

  private String country;

  private String name;

  private String code;

  private Integer decimals;

  private String symbol;
}
