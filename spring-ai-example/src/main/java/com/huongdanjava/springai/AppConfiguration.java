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
        "<your_api_token_here>");
  }

  @Bean
  ChatModel chatModel(OpenAiApi openAiApi) {
    return new OpenAiChatModel(openAiApi,
        OpenAiChatOptions.builder().model(OpenAiApi.ChatModel.O1_MINI).build());
  }
}
