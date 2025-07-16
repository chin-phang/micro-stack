package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyDto {

  private Long currencyId;

  private String currencyCountry;

  private String currencyName;

  private String currencyCode;

  private Integer currencyDecimals;

  private String currencySymbol;
}
