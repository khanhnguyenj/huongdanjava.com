package com.huongdanjava.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
        .formLogin();
    // @formatter:on

    return http.build();
  }

  // @Override
  // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  // auth.inMemoryAuthentication()
  // .withUser("khanh").password("{noop}123456").roles("USER")
  // .and()
  // .withUser("thanh").password("{noop}123456").roles("ADMIN");
  // }
  //
  // @Override
  // protected void configure(HttpSecurity http) throws Exception {
  // http.authorizeRequests()
  // .antMatchers("/").hasRole("USER")
  // .antMatchers("/admin/**").hasRole("ADMIN")
  // .and().formLogin();
  // }
  //
  // @Override
  // public void configure(WebSecurity web) throws Exception {
  // web.ignoring().antMatchers("/resources/**");
  // }
}
