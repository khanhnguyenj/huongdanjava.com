package com.huongdanjava.springai;

import io.micrometer.observation.ObservationRegistry;
import java.util.List;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.model.tool.ToolCallingChatOptions;
import org.springframework.ai.model.tool.ToolCallingManager;
import org.springframework.ai.model.tool.ToolExecutionResult;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.ai.tool.definition.ToolDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.support.RetryTemplate;

@Configuration
public class AppConfiguration {

  @Bean
  OpenAiApi openAiApi() {
    return new OpenAiApi.Builder()
        .apiKey("<YOUR_API_KEY_HERE>")
        .build();
  }

  @Bean
  ChatModel chatModel(OpenAiApi openAiApi, ToolCallingManager toolCallingManager,
      RetryTemplate retryTemplate, ObservationRegistry observationRegistry) {
    OpenAiChatOptions openAiChatOptions = OpenAiChatOptions.builder()
        .model(OpenAiApi.ChatModel.GPT_5_NANO)
        .build();

    return new OpenAiChatModel(openAiApi, openAiChatOptions, toolCallingManager, retryTemplate,
        observationRegistry);
  }

  @Bean
  RetryTemplate retryTemplate() {
    return new RetryTemplate();
  }

  @Bean
  ToolCallingManager toolCallingManager() {
    return new ToolCallingManager() {
      @Override
      public List<ToolDefinition> resolveToolDefinitions(ToolCallingChatOptions chatOptions) {
        return List.of();
      }

      @Override
      public ToolExecutionResult executeToolCalls(Prompt prompt, ChatResponse chatResponse) {
        return null;
      }
    };
  }

  @Bean
  ObservationRegistry observationRegistry() {
    return ObservationRegistry.create();
  }
}

