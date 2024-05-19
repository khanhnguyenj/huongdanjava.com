package com.huongdanjava.springai;

import org.springframework.ai.chat.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAiExampleApplication implements CommandLineRunner {

  @Autowired
  private ChatClient chatClient;

  public static void main(String[] args) {
    SpringApplication.run(SpringAiExampleApplication.class, args);
  }

  @Override
  public void run(String... args) {
    String output = chatClient.call("Do you know about Huong Dan Java website?");

    System.out.println(output);
  }
}
