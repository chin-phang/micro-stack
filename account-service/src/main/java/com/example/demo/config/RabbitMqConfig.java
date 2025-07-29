package com.example.demo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class RabbitMqConfig {

  @Bean
  public Queue accountEmailQueue() {
    return new Queue("account-email");
  }

}
