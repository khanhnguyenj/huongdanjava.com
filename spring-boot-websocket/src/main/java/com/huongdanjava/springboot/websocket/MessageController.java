package com.huongdanjava.springboot.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @MessageMapping("/hello")
    @SendTo("/topic/messages")
    public String send(String username) {
        return "Hello, " + username;
    }
}
