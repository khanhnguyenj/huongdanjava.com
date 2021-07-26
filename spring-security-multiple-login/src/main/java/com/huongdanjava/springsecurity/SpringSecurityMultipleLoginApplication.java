package com.huongdanjava.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
public class SpringSecurityMultipleLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityMultipleLoginApplication.class, args);
    }

    @Bean
    public UserDetailsService userDetailsService() throws Exception {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User
            .withUsername("user")
            .password(encoder().encode("user"))
            .roles("USER")
            .build());

        manager.createUser(User
            .withUsername("admin")
            .password(encoder().encode("admin"))
            .roles("ADMIN")
            .build());

        return manager;
    }

    @Bean
    public static PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
