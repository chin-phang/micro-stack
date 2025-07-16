package com.example.demo.entity;

import com.example.demo.enumeration.AccountStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account extends Auditable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "account_id", nullable = false)
  private Long id;

  @Column(name = "account_no", length = 20, nullable = false, unique = true)
  private String accountNo;

  @Column(name = "account_status", length = 20, nullable = false)
  @Enumerated(EnumType.STRING)
  private AccountStatus status;

  @ManyToOne(fetch = FetchType.LAZY)
  private User user;

  @OneToOne(mappedBy = AccountProfile_.ACCOUNT, cascade = CascadeType.ALL, orphanRemoval = true,
      fetch = FetchType.LAZY)
  private AccountProfile profile;

  @OneToOne(mappedBy = AccountBalance_.ACCOUNT, cascade = CascadeType.ALL, orphanRemoval = true,
      fetch = FetchType.LAZY)
  private AccountBalance balance;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Account that = (Account) o;
    return Objects.equals(accountNo, that.getAccountNo());
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountNo);
  }
}
