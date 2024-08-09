package com.example.chat_backend.Model;

import lombok.Data;

@Data
public class Message {
    private String senderName;
    private String receiverName;
    private String message;
    private String date;
    private Status status;

    public enum Status {
        JOIN,
        MESSAGE,
        LEAVE
    }
}
