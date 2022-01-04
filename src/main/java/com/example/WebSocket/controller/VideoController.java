
package com.example.WebSocket.controller;

import com.example.WebSocket.model.VideoStream;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

/**
 *
 * @author KassiAyoub
 */

@Controller
public class VideoController {

    @MessageMapping("/video.play")
    @SendTo("/topic/public")
    public StreamVideo sendMessage(@Payload final VideoStream videoStream){
        return chatMessage;
    }

    @MessageMapping("/video.pause")
    @SendTo("/topic/public")
    public StreamVideo sendMessage(@Payload final VideoStream videoStream){
        return chatMessage;
    }


    @MessageMapping("/video.change")
    @SendTo("/topic/public")
    public  StreamVideo newVideo(@Payload final VideoStream videoStream ,
            SimpMessageHeaderAccessor headerAccessor){

        headerAccessor.getSessionAttributes().put("videoid", videoStream.getID());

        return videoStream;

    }




}
