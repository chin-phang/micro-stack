package com.example.demo.dto;

import com.example.demo.enumeration.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

  private String accountNo;

  private AccountStatus status;

  private Long userId;

  private AccountProfileDto profile;

  private AccountBalanceDto balance;
}
