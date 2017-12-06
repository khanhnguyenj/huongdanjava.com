package com.huongdanjava.aspectjexample;

public class Example {

    public static void main(String[] args) {
        Application application = new Application();

        int a = 10;
        int b = 3;

        System.out.println(application.sum(a, b));
        System.out.println(application.sub(a, b));
    }
}
