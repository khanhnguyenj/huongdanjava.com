package com.huongdanjava.springai;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

  @Bean
  OpenAiChatOptions chatOptions() {
    return OpenAiChatOptions.builder()
        .apiKey("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")
        .model(com.openai.models.ChatModel.GPT_5_NANO.asString())
        .build();
  }

  @Bean
  ChatModel chatModel(OpenAiChatOptions chatOptions) {
    return OpenAiChatModel.builder().options(chatOptions).build();
  }
}
