package com.huongdanjava.springai;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

  static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        AppConfiguration.class);

    ChatModel chatModel = context.getBean(ChatModel.class);
    ChatResponse chatResponse = chatModel.call(
        new Prompt("Do you know about Huong Dan Java website?"));
    System.out.println(chatResponse.getResult());
  }

}