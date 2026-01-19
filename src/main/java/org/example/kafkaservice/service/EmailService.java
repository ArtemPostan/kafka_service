package org.example.kafkaservice.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    // Пока сделаем заглушку, чтобы проверить само API
    public void sendSimpleEmail(String to, String text) {
        System.out.println("========================================");
        System.out.println("LOG: Отправка письма для: " + to);
        System.out.println("LOG: Текст: " + text);
        System.out.println("========================================");
    }
}