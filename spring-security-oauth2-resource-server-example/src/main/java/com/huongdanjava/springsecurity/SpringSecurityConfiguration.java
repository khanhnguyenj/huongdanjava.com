package com.huongdanjava.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SpringSecurityConfiguration {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    // @formatter:off
    http
        .authorizeHttpRequests((authz) -> authz
            .antMatchers("/hello").hasAuthority("SCOPE_access-hello")
            .anyRequest().authenticated()
        )
        .oauth2ResourceServer().jwt();
    // @formatter:on

    return http.build();
  }

}
