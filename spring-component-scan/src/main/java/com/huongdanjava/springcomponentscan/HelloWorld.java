package com.huongdanjava.springcomponentscan;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld {
    
    public void print()  {
        System.out.print("Hello World!");
    }
}