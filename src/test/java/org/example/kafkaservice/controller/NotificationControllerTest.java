package org.example.kafkaservice.controller;

import org.example.kafkaservice.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(NotificationController.class)
class NotificationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmailService emailService;

    @Test
    void shouldReturnOkStatus() throws Exception {
        mockMvc.perform(post("/api/notifications/send")
                        .param("email", "test@mail.com")
                        .param("message", "Test message"))
                .andExpect(status().isOk())
                .andExpect(content().string("Письмо отправлено в консоль!"))
                .andDo(print());
        verify(emailService, times(1)).sendSimpleEmail("test@mail.com", "Test message");
    }
}