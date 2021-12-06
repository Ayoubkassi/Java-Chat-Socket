package com.example.WebSocket.model;


import lombok.Builder;
import lombok.Getter;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ryota
 */


@Builder
public class ChatMessage {
    
    @Getter
    private MessageType type;
    
    @Getter
    private String content;
    
    @Getter
    private String sender;
    
    @Getter
    private String time;

    public String getSender() {
        return sender;
    }
    
    
    
    
}
