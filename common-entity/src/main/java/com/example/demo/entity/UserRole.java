package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "users_roles")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRole extends Auditable {

  @Id
  @ManyToOne
  private User user;

  @Id
  @ManyToOne
  private Role role;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserRole that = (UserRole) o;
    return Objects.equals(user, that.user) &&
        Objects.equals(role, that.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(user, role);
  }
}
