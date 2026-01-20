package org.example.kafkaservice.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEvent {
    private String email;
    private String action;

    public String getAction() {
        return action;
    }

    public String getEmail() {
        return email;
    }
}