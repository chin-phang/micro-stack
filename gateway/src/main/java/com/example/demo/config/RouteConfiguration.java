package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions.uri;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import static org.springframework.web.servlet.function.RouterFunctions.route;

@Configuration
public class RouteConfiguration {

  @Bean
  public RouterFunction<ServerResponse> authRoutes() {
    return route()
        .GET("/api/auth/**", http())
        .before(uri("http://localhost:8080/auth"))
        .build();
  }
}
