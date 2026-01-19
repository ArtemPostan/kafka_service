package org.example.kafkaservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor // Добавь эту аннотацию (из Lombok) для внедрения EmailService
public class NotificationListener {

    private final EmailService emailService;

    @KafkaListener(topics = "${app.kafka.topic}", groupId = "notification-group")
    public void listen(String message) {
        // Когда пришло из Кафки — отправляем через сервис
        emailService.sendSimpleEmail("admin@test.com", message);
    }
}