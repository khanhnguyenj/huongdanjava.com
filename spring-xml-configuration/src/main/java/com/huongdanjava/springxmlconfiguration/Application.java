package com.huongdanjava.springxmlconfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        // Call Spring container
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        // Request to get Drawing object
        Drawing drawing = (Drawing) context.getBean("drawing");

        drawing.draw();
    }
}