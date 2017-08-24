package com.huongdanjava.lombok;

import lombok.Synchronized;

public class Example {

    @Synchronized
    public int calculate(int a, int b) {
        return a + b;
    }
}
