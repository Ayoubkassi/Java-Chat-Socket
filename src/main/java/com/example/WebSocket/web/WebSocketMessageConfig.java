package com.example.WebSocket.web;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
//import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ryota
 */

@Configuration //this is tell spring boot that is it spring configuration class
@EnableWebSocketMessageBroker  //enable websocket message brocker
//@EnableScheduling
public class WebSocketMessageConfig implements WebSocketMessageBrokerConfigurer{
    
    
    //we gonna have 2 methods 
    @Override
    public void registerStompEndpoints(final StompEndpointRegistry registry){
        registry.addEndpoint("/watch-youtube").withSockJS();
    }
    
    //SECOND ONE
    
    @Override
    public void configureMessageBroker(final MessageBrokerRegistry registry){
        registry.setApplicationDestinationPrefixes("/app");
        //enable message brocker to store our data messages
        registry.enableSimpleBroker("/topic");
        
    }
}
