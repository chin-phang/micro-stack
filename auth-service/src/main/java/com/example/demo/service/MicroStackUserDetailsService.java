package com.example.demo.service;

import com.example.demo.entityGraphs.UserEntityGraphPath;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MicroStackUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findByUsername(username, UserEntityGraphPath.UserWithRolesAndUserInfoAndTenant.getEntityGraph())
        .orElseThrow(
            () -> new UsernameNotFoundException(
                String.format("User: %s, not found", username)
            ));
  }
}
