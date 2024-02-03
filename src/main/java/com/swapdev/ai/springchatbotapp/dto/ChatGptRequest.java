package com.swapdev.ai.springchatbotapp.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChatGptRequest {
    private String model;
    private List<Message> messages;

    public ChatGptRequest(String model, String prompts) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new Message("user",prompts));
    }
}
