package com.huongdanjava.springsetterinjection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        BeanFactory context = new ClassPathXmlApplicationContext("spring.xml");

        Clazz clazz = (Clazz) context.getBean("clazz");
        System.out.println(clazz.toString());
    }

}
