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
 * @author KassiAyoub
 */

@Component
public class WebSocketEventListener {


    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketEventListener.class);

    @Autowired
    private SimpMessageSendingOperations sendingOperations;

    @EventListener
    public void handleWebSocketEventListener(final SessionConnectedEvent event){

        LOGGER.info("Serveur back-end commence l'ecoute");
    }

    @EventListener
    public void handleWebSocketDisconnectListener(final SessionDisconnectEvent event){
        final StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getVideo());

        final String id = (String) headerAccessor.getSessionAttributes().get("id");

        final VideoStream videoStream = ChatMessage.builder().type(VideoType.PAUSE)
                .sender(id)
                .build();

        sendingOperations.convertAndSend("/topic/public", chatMessage);






    }
}
