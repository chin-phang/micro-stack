package com.example.demo.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "account-email")
public class accountEmailReceiver {

  @RabbitHandler
  public void handleAccountCreated(String message) {

  }
}
