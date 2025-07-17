package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "account_profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountProfile extends Auditable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "account_profile_id", nullable = false)
  private Long id;

  @Column(name = "first_name", length = 100)
  private String firstName;

  @Column(name = "last_name", length = 100)
  private String lastName;

  @Column(name = "email", length = 100, nullable = false, unique = true)
  private String email;

  @Column(name = "mobile_phone", length = 20, unique = true)
  private String mobilePhone;

  @Column(name = "address_line_1")
  private String addressLine1;

  @Column(name = "address_line_2")
  private String addressLine2;

  @Column(name = "city", length = 50)
  private String city;

  @Column(name = "state", length = 50)
  private String state;

  @Column(name = "postal_code", length = 10)
  private String postalCode;

  @Column(name = "country", length = 50)
  private String country;

  @OneToOne(fetch =  FetchType.LAZY)
  @JoinColumn(name = "account_id")
  private Account account;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AccountProfile that = (AccountProfile) o;
    return Objects.equals(email, that.getEmail()) &&
        Objects.equals(mobilePhone, that.getMobilePhone());
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, mobilePhone);
  }
}
