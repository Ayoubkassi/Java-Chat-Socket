/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.WebSocket.controller;

import com.example.WebSocket.model.ChatMessage;
import com.example.WebSocket.model.MessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

/**
 *
 * @author ryota
 */

@Component
public class WebSocketEventListener {
    
    
    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketEventListener.class);
            
    @Autowired
    private SimpMessageSendingOperations sendingOperations;
    
    @EventListener
    public void handleWebSocketEventListener(final SessionConnectedEvent event){
        
        LOGGER.info("Hey Hey and welcome again we have a new connection here");
    }
    
    @EventListener
    public void handleWebSocketDisconnectListener(final SessionDisconnectEvent event){
        final StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        
        final String username = (String) headerAccessor.getSessionAttributes().get("username");
        
        final ChatMessage chatMessage = ChatMessage.builder().type(MessageType.DISCONNECT)
                .sender(username)
                .build();
        
        sendingOperations.convertAndSend("/topic/public", chatMessage);
        
        
        
        
        
        
    }
}
