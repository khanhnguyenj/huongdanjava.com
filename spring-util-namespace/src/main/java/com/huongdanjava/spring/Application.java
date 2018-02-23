package com.huongdanjava.spring;

import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Properties p = (Properties) context.getBean("properties");

        System.out.println(p.get("app.author"));
    }
}
