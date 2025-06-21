package com.whatsapp.whatsappbot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String id;         // Firebase doc ID (optional)
    private String sender;     // Who sent the message (e.g. phone number)
    private String content;    // The actual message
    private long timestamp;    // Time sent (Epoch milliseconds)
}
