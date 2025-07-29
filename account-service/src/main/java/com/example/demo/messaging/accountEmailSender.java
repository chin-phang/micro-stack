package com.example.demo.messaging;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class accountEmailSender {

  private final RabbitTemplate rabbitTemplate;

  private final Queue queue;

  public void send(String message) {
    rabbitTemplate.convertAndSend(queue.getName(), message);
  }
}
