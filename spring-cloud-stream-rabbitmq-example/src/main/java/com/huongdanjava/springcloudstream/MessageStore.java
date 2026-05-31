package com.huongdanjava.springcloudstream;

import org.springframework.stereotype.Component;

@Component
public class MessageStore {

    private String lastMessage;

    public void setLastMessage(String message) {
        this.lastMessage = message;
    }

    public String getLastMessage() {
        return lastMessage;
    }
}