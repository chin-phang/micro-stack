package com.example.demo.dto;

import com.example.demo.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WalletBalanceDto {

  private Long walletBalanceId;

  private String currencyCode;

  private Long balanceAmount;

  private Long lockedBalanceAmount;

  private Long availableBalanceAmount;

  private Account account;
}
