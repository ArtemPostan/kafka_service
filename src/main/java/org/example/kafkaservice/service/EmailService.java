package org.example.kafkaservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendSimpleEmail(String to, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("noreply@myapp.com");
            message.setTo(to);
            message.setSubject("Уведомление от системы");
            message.setText(text);

            mailSender.send(message);
            System.out.println("Письмо успешно отправлено на: " + to);
        } catch (Exception e) {
            System.err.println("Ошибка при отправке письма: " + e.getMessage());
        }
    }
}