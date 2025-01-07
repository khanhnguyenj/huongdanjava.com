package com.huongdanjava.springai;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

  @Bean
  OpenAiApi openAiApi() {
    return new OpenAiApi(
        "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");
  }

  @Bean
  ChatModel chatModel(OpenAiApi openAiApi) {
    return new OpenAiChatModel(openAiApi,
        OpenAiChatOptions.builder().model(OpenAiApi.ChatModel.O1_MINI).build());
  }
}
