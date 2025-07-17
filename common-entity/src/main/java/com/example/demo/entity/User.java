package com.example.demo.entity;

import com.example.demo.enumeration.RoleName;
import com.example.demo.enumeration.UserStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends Auditable implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id", nullable = false)
  private Long id;

  @Column(name = "username", length = 100, nullable = false, unique = true)
  private String username;

  @Column(name = "password", length = 100, nullable = false)
  private String password;

  @Column(name = "user_status", nullable = false)
  @Enumerated(EnumType.STRING)
  private UserStatus status;

  @OneToMany(mappedBy = Account_.USER)
  private List<Account> accounts = new ArrayList<>();

  @OneToMany(mappedBy = UserRole_.USER, cascade = CascadeType.ALL, orphanRemoval = true)
  private List<UserRole> roles = new ArrayList<>();

  public void addAccount(Account account) {
    this.accounts.add(account);
    account.setUser(this);
  }

  public void removeAccount(Account account) {
    this.accounts.remove(account);
    account.setUser(null);
  }

  public void addRole(Role role) {
    UserRole userRole = new UserRole(this, role);
    this.roles.add(userRole);
    role.getUsers().add(userRole);
  }

  public void removeRole(Role role) {
    UserRole userRole = new UserRole(this, role);
    role.getUsers().remove(userRole);
    this.roles.remove(userRole);
    userRole.setUser(null);
    userRole.setRole(null);
  }

  public boolean isSupportL3() {
    return roles.stream().anyMatch(userRole -> userRole.getRole().getName().equals(RoleName.ROLE_SUPPORT_L3.name()));
  }

  public boolean isSupportL2() {
    return roles.stream().anyMatch(userRole -> userRole.getRole().getName().equals(RoleName.ROLE_SUPPORT_L2.name()));
  }

  public boolean isMerchantAdmin() {
    return roles.stream().anyMatch(userRole -> userRole.getRole().getName().equals(RoleName.ROLE_MERCHANT_ADMIN.name()));
  }

  public boolean isMerchantUser() {
    return roles.stream().anyMatch(userRole -> userRole.getRole().getName().equals(RoleName.ROLE_MERCHANT_USER.name()));
  }

  public boolean isAppUser() {
    return roles.stream().anyMatch(userRole -> userRole.getRole().getName().equals(RoleName.ROLE_APP_USER.name()));
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<SimpleGrantedAuthority> authorities = new ArrayList<>();

    List<Role> roleList = roles.stream()
        .map(UserRole::getRole)
        .toList();

    for (Role role : roleList) {
      authorities.add(new SimpleGrantedAuthority(role.getName()));
    }

    return authorities;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return status.isActive();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User that = (User) o;
    return Objects.equals(username, that.username);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username);
  }
}