package com.firefly.myapp.dto;

import com.firefly.myapp.model.Messages;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MessageDTO {
    @NotBlank(message = "Text cannot be empty")
    private String text;

    public Messages toMessages() {
        Messages message = new Messages();
        message.setText(text);
        return message;
    }
}
