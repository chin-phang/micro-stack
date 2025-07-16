package com.example.demo.controller;

import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

  private final AuthService authService;

  @PostMapping("/login")
  public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginReq) {
    return ResponseEntity.ok(authService.authenticate(loginReq));
  }

  @PostMapping("/register")
  public void register(@RequestBody RegisterRequest registerReq) throws Exception {
    authService.register(registerReq);
  }

  @PostMapping("/logout")
  public void logout() {
    authService.logout();
  }
}
