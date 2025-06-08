package com.ezedin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class NotificationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

    @RabbitListener(queues = "userQueue")
    public void handleNotification(OrderPlacedMessage orderPlacedMessage) {
        log.info("Received Notification for order : {}", orderPlacedMessage.getOrderNumber());
    }

}
