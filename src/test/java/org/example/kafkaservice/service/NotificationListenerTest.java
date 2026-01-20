package org.example.kafkaservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NotificationListenerTest {

    @Mock
    private EmailService emailService;

    @InjectMocks
    private NotificationListener notificationListener;

    @Test
    void shouldParseJsonAndSendEmail() throws Exception {

        String jsonMessage = "{\"email\":\"test@example.com\", \"action\":\"REGISTRATION\"}";

        notificationListener.listen(jsonMessage);

        verify(emailService, times(1))
                .sendSimpleEmail("test@example.com", "Действие: REGISTRATION");
    }

    @Test
    void shouldHandleInvalidJson() {

        String invalidJson = "{invalid}";

        notificationListener.listen(invalidJson);

        verify(emailService, never()).sendSimpleEmail(anyString(), anyString());
    }
}