package com.whatsapp.whatsappbot.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whatsapp.whatsappbot.entity.Message;
import com.whatsapp.whatsappbot.service.ChatService;

@RestController
@RequestMapping("/api/chat")
public class ChatController {


    @Autowired
    private ChatService chatService;

    // Simulate receiving a WhatsApp message (POST)
    @PostMapping("/message")
    public String receiveMessage(@RequestBody Message message) throws ExecutionException, InterruptedException {
        String id = chatService.saveMessage(message);
        return "Message saved with ID: " + id;
    }

    // Get all stored messages (GET)
    @GetMapping("/messages")
    public List<Message> getMessages() throws ExecutionException, InterruptedException {
        return chatService.getAllMessages();
    }
}
