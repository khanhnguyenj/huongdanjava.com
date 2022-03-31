package com.huongdanjava.springsecurity;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    // @formatter:off
    http
        .authorizeHttpRequests((authz) -> authz
            .antMatchers("/").hasRole("USER")
            .antMatchers("/admin/**").hasRole("ADMIN")
        )
        .formLogin(withDefaults());
    // @formatter:on

    return http.build();
  }

  @Bean
  public UserDetailsManager userDetailsService() {
    // @formatter:off
    UserDetails user1 = User.withDefaultPasswordEncoder()
        .username("khanh")
        .password("123456")
        .roles("USER")
        .build();
    UserDetails user2 = User.withDefaultPasswordEncoder()
        .username("thanh")
        .password("123456")
        .roles("ADMIN")
        .build();
    // @formatter:on

    return new InMemoryUserDetailsManager(user1, user2);
  }

  @Bean
  public WebSecurityCustomizer webSecurityCustomizer() {
    return (web) -> web.ignoring().antMatchers("/resources/**");
  }
}
