/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.WebSocket.controller;

import com.example.WebSocket.model.VideoStream ;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

/**
 *
 * @author ryota
 */

@Controller
public class VideoController {

    @MessageMapping("/video.play")
    @SendTo("/topic/public")
    public StreamVideo sendMessage(@Payload final ChatMessage chatMessage){
        return chatMessage;
    }


    @MessageMapping("/video.pasue")
    @SendTo("/topic/public")
    public  StreamVideo newUser(@Payload final ChatMessage chatMessage ,
            SimpMessageHeaderAccessor headerAccessor){

        headerAccessor.getSessionAttributes().put("video", chatMessage.getSender());

        return chatMessage;

    }




}
