package com.example.demo.service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.entityGraphs.UserEntityGraphPath;
import com.example.demo.jwt.JwtTokenProvider;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final UserRepository userRepository;


  private final RoleRepository roleRepository;

  private final AuthenticationManager authenticationManager;

  private final JwtTokenProvider jwtTokenProvider;

  @Transactional(rollbackFor = {Exception.class})
  public void register(RegisterRequest registerReq) throws Exception {

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String saltPassword = passwordEncoder.encode(registerReq.getPassword());

    /*User user = User.builder()
        .username(registerReq.getUsername())
        .password(saltPassword)
        .build();

    user.addRoles(roleRepository.findByName("ROLE_EMPLOYEE"));
    if (registerReq.isAdmin()) {
      user.addRoles(roleRepository.findByName("ROLE_ADMIN"));
    }

    userRepository.save(user);*/
  }

  public LoginResponse authenticate(LoginRequest loginReq) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginReq.getUsername(), loginReq.getPassword()));

    User user = userRepository.findByUsername(loginReq.getUsername(), UserEntityGraphPath.UserWithRoles.getEntityGraph())
        .orElseThrow(() -> new IllegalArgumentException("Invalid username or password."));

    String jwtToken = jwtTokenProvider.generateToken(user);

    return LoginResponse.builder()
        .accessToken(jwtToken)
        .build();
  }

  public void logout() {

  }
}
