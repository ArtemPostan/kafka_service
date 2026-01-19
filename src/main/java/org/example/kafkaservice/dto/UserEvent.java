package org.example.kafkaservice.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEvent {
    private String email;
    private String action;

    // Добавляем геттеры вручную, раз Lombok не подхватился
    public String getAction() {
        return action;
    }

    public String getEmail() {
        return email;
    }
}