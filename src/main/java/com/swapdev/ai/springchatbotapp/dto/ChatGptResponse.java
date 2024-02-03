package com.swapdev.ai.springchatbotapp.dto;

import lombok.Data;

import java.util.List;
@Data
public class ChatGptResponse {
private List<Choice>choices;
}
