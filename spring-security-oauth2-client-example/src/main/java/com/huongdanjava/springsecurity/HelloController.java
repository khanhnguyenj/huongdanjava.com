package com.huongdanjava.springsecurity;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.clientRegistrationId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class HelloController {

  @Autowired
  private WebClient webClient;

  @GetMapping("/hello")
  public String hello(@RequestParam String name) {
    // @formatter:off
    String responseFromResourceServer = webClient.get()
        .uri("http://localhost:8081/hello")
        .attributes(clientRegistrationId("huongdanjava1"))
        .retrieve()
        .bodyToMono(String.class)
        .block();
    // @formatter:on

    return String.format("%s %s", responseFromResourceServer, name);
  }
}
