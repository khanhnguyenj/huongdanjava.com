package com.huongdanjava.springboot.internationalization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

@SpringBootApplication
public class SpringBootInternationalizationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootInternationalizationApplication.class, args);
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:i18n/messages");

        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new CookieLocaleResolver();
    }

}
