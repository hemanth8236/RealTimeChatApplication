package com.chat.app.controller;

import com.chat.app.model.ChatMessage;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @MessageMapping("/sendmessage/{roomId}")
    @SendTo("/topic/messages/{roomId}")
    public ChatMessage sendMessage(@DestinationVariable String roomId, ChatMessage message) {
        // Optionally, you can set the roomId in the message here
        return message;
    }

    @GetMapping("/chat/{roomId}")
    public String chat() {
        return "chat";
    }
}
