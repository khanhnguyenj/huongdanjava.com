package com.huongdanjava.springsecurity;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
        .withUser("khanh").password("{noop}123456").roles("USER")
        .and()
        .withUser("thanh").password("{noop}123456").roles("ADMIN");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/").hasRole("USER")
        .antMatchers("/admin/**").hasRole("ADMIN")
        .and().formLogin();
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/resources/**");
  }
}
