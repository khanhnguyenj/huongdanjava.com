package com.huongdanjava.springboot.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/hello").withSockJS();
  }

  @Override
  public void configureMessageBroker(MessageBrokerRegistry registry) {
    // registry.enableSimpleBroker("/topic");

    // @formatter:off
    registry.enableStompBrokerRelay("/topic")
        .setRelayHost("172.17.0.1")
        .setRelayPort(61613)
        .setSystemLogin("guest")
        .setSystemPasscode("guest");
    // @formatter:on

    registry.setApplicationDestinationPrefixes("/app");
  }
}
