package com.huongdanjava.springusingpropertiesinspringxml;

public class HelloWorld {

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
