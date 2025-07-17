package com.example.demo.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountBalanceDto extends BaseDto {

  private String currencyCode;

  private Long balanceAmount;

  private Long lockedBalanceAmount;

  private Long availableBalanceAmount;

  private BigDecimal balanceAmountDisplay;

  private BigDecimal lockedBalanceAmountDisplay;

  private BigDecimal availableBalanceAmountDisplay;

  private Long accountId;
}
