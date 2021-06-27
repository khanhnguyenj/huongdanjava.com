package com.huongdanjava.springboot.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @MessageMapping("/hello")
    @SendToUser("/queue/reply")
    public String send(String username) {
        return "Hello, " + username;
    }
}