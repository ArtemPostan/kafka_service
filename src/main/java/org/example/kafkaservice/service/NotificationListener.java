package org.example.kafkaservice.service;

import com.fasterxml.jackson.databind.ObjectMapper; // Импорт Jackson
import lombok.RequiredArgsConstructor;
import org.example.kafkaservice.dto.UserEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationListener {

    private final EmailService emailService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "${app.kafka.topic}", groupId = "notification-group")
    public void listen(String message) {
        try {
            UserEvent event = objectMapper.readValue(message, UserEvent.class);

            String email = event.getEmail();
            String text = "Действие: " + event.getAction();

            emailService.sendSimpleEmail(email, text);

        } catch (Exception e) {
            System.err.println("Ошибка при чтении сообщения из Kafka: " + e.getMessage());
            System.err.println("Сырое сообщение: " + message);
        }
    }
}