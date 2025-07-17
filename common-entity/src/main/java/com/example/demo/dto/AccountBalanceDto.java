package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountBalanceDto {

  private String currencyCode;

  private Long balanceAmount;

  private Long lockedBalanceAmount;

  private Long availableBalanceAmount;

  private BigDecimal balanceAmountDisplay;

  private BigDecimal lockedBalanceAmountDisplay;

  private BigDecimal availableBalanceAmountDisplay;

  private Long accountId;
}
