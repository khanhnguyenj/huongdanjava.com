package com.huongdanjava.java;

public class Calculator implements Runnable {

    public void run() {
        System.out.println("Calculator : " + Thread.currentThread().getName());

        int a = 2;
        int b = 7;

        int sum = a + b;

        System.out.println(sum);
    }

}