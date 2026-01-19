package org.example.kafkaservice.controller; // Убедись, что путь совпадает с твоим проектом

import lombok.RequiredArgsConstructor;
import org.example.kafkaservice.service.EmailService; // Импорт твоего сервиса из соседнего пакета
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final EmailService emailService;

    @PostMapping("/send")
    public String sendManual(@RequestParam String email, @RequestParam String message) {
        emailService.sendSimpleEmail(email, message);
        return "Письмо отправлено в консоль!";
    }
}