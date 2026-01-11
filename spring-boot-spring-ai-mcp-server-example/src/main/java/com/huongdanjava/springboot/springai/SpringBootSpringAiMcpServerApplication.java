package com.huongdanjava.springboot.springai;

import java.util.List;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootSpringAiMcpServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootSpringAiMcpServerApplication.class, args);
  }

  @Bean
  List<ToolCallback> toolCallbacks(HuongDanJava huongDanJava) {
    return List.of(ToolCallbacks.from(huongDanJava));
  }

}
