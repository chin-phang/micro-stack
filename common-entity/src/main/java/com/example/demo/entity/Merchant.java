package com.example.demo.entity;

import com.example.demo.enumeration.MerchantStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "merchants")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Merchant extends Auditable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "merchant_id", nullable = false)
  private Long id;

  @Column(name = "merchant_name", length = 100, nullable = false)
  private String name;

  @Column(name = "merchant_code", length = 10, nullable = false, unique = true)
  private String code;

  @Column(name = "merchant_status", length = 20, nullable = false)
  @Enumerated(EnumType.STRING)
  private MerchantStatus status;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "parent_merchant_id")
  private Merchant parent;

  @Column(name = "hierarchy_level", nullable = false)
  private Integer hierarchyLevel;

  @OneToMany(mappedBy = Merchant_.PARENT, cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Merchant> children = new ArrayList<>();

  public void addChildren(Merchant merchant) {
    children.add(merchant);
    merchant.setParent(this);
  }

  public void removeChildren(Merchant merchant) {
    children.remove(merchant);
    merchant.setParent(null);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Merchant that = (Merchant) o;
    return Objects.equals(code, that.getCode());
  }

  @Override
  public int hashCode() {
    return Objects.hash(code);
  }
}
