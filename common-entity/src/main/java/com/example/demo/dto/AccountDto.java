package com.example.demo.dto;

import com.example.demo.enumeration.AccountStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto extends  BaseDto {

  private String accountNo;

  private AccountStatus status;

  private Long userId;

  private AccountProfileDto profile;

  private AccountBalanceDto balance;
}
