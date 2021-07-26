package com.huongdanjava.springsecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SpringSecurityConfiguration {

    @Configuration
    @Order(1)
    public class UserSpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // @formatter:off
            http.antMatcher("/user/**")
                    .authorizeRequests()
                        .anyRequest().hasRole("USER")
                        .and()
                    .formLogin()
                        .loginPage("/user-login")
                        .failureUrl("/user-login?error")
                        .permitAll();
            // @formatter:on
        }
    }

    @Configuration
    public class AdminSpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // @formatter:off
            http
                .authorizeRequests()
                    .antMatchers("/user-login/**").permitAll()
                    .anyRequest().hasRole("ADMIN")
                    .and()
                .formLogin(Customizer.withDefaults());
            // @formatter:on
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers("/webjars/**");
        }
    }

}
