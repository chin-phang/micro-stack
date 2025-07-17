package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "currencies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Currency {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "currency_id", nullable = false)
  private Long id;

  @Column(name = "currency_country", length = 50, nullable = false)
  private String country;

  @Column(name = "currency_name", length = 100, nullable = false)
  private String name;

  @Column(name = "currency_code", length = 5, nullable = false, unique = true)
  private String code;

  @Column(name = "currency_decimals", nullable = false)
  private Integer decimals;

  @Column(name = "currency_symbol", length = 5)
  private String symbol;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Currency that = (Currency) o;
    return Objects.equals(code, that.getCode());
  }

  @Override
  public int hashCode() {
    return Objects.hash(code);
  }
}
