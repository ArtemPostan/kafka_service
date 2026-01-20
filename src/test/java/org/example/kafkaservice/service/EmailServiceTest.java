package org.example.kafkaservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EmailServiceTest {

    @Mock
    private JavaMailSender mailSender;

    @InjectMocks
    private EmailService emailService;

    @Test
    void shouldSendEmailSuccessfully() {
        // Arrange
        String to = "test@example.com";
        String text = "Hello Test";

        // Act
        emailService.sendSimpleEmail(to, text);

        // Assert
        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
    }
}