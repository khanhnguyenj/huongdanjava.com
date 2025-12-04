package com.huongdanjava.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(HDJBeanRegistrar.class)
public class AppConfig {

}
