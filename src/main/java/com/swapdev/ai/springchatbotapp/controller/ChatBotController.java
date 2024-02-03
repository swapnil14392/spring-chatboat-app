package com.swapdev.ai.springchatbotapp.controller;

import com.swapdev.ai.springchatbotapp.dto.ChatGptRequest;
import com.swapdev.ai.springchatbotapp.dto.ChatGptResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/bot")
@RestController
public class ChatBotController {
    @Value("${openai.model}")
    private String model;

    @Value("${openai.url}")
    private String apiUrl;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/chat")
    public String chat(@RequestParam ("prompt") String prompt){
        ChatGptRequest request=new ChatGptRequest(model,prompt);
        ChatGptResponse chatGptResponse= restTemplate.postForObject(apiUrl,request,ChatGptResponse.class);
        return chatGptResponse.getChoices().get(0).getMessage().getContent();
    }
}
