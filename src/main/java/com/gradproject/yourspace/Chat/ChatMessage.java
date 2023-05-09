package com.gradproject.yourspace.Chat;

import java.time.Instant;


 public class ChatMessage {

    private Long id;
    private String content;
    private String sender;
    private String recipient;
    private Instant timestamp;

    private MessageType type;

     public enum MessageType {
         CHAT,
         JOIN,
         LEAVE
     }



     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

     public void setType(MessageType type) {
         this.type = type;
     }

     public String getContent() {
         return content;
     }

     public MessageType getType() {
         return type;
     }
 }
