package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "account_balances")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountBalance extends Auditable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "account_balance_id", nullable = false)
  private Long id;

  @Column(name = "currency_code", length = 10, nullable = false)
  private String currencyCode;

  @Column(name = "balance_amount", nullable = false)
  private Long balanceAmount;

  @Column(name = "locked_balance_amount")
  private Long lockedBalanceAmount;

  @Column(name = "available_balance_amount", nullable = false)
  private Long availableBalanceAmount;

  @OneToOne(fetch =  FetchType.LAZY)
  @JoinColumn(name = "account_id")
  private Account account;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AccountBalance that = (AccountBalance) o;
    return Objects.equals(id, that.getId()) &&
        Objects.equals(currencyCode, that.getCurrencyCode());
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, currencyCode);
  }
}
