package com.whatsapp.whatsappbot.service;


import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.whatsapp.whatsappbot.entity.Message;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ChatService {

    private static final String COLLECTION_NAME = "chat_messages";

    public String saveMessage(Message message) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        message.setTimestamp(System.currentTimeMillis());

        ApiFuture<DocumentReference> future = db.collection(COLLECTION_NAME).add(message);

        // Generate bot response
        String botReply = generateBotReply(message.getContent());
        Message botMessage = new Message();
        botMessage.setSender("BOT");
        botMessage.setContent(botReply);
        botMessage.setTimestamp(System.currentTimeMillis());
        db.collection(COLLECTION_NAME).add(botMessage);
        return future.get().getId(); // returns the Firebase doc ID
    }

    private String generateBotReply(String input) {
    String msg = input.toLowerCase().trim();

        return switch (msg) {
            case "hi", "hello" -> "Hello! How can I assist you?";
            case "help" -> "Sure! I can help with your queries. Try saying 'hi', 'info', or 'bye'.";
            case "info" -> "This is a demo WhatsApp chatbot backend built using Java and Firebase.";
            case "bye" -> "Goodbye! Have a great day!";
            default -> "Sorry, I didn't understand that. Type 'help' for options.";
        };
    }

    public List<Message> getAllMessages() throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = db.collection(COLLECTION_NAME).get();

        List<Message> messages = new ArrayList<>();
        for (DocumentSnapshot doc : future.get().getDocuments()) {
            Message msg = doc.toObject(Message.class);
            if (msg != null) {
                msg.setId(doc.getId());
                messages.add(msg);
            }
        }
        return messages;
    }
}
