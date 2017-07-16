package com.huongdanjava.springvalueannotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloWorld {

    @Value("${name1:Huong Dan Java}")
    private String name;

    public void print()  {
        System.out.print("Hello " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
