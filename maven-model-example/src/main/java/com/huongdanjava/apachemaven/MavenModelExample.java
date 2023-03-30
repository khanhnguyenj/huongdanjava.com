package com.huongdanjava.apachemaven;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class MavenModelExample {

    public static void main(String[] args) throws FileNotFoundException {
        String pomXml = "/Users/khanh/Documents/code/huongdanjava.com/spring-boot-actuator";
        Reader reader = new FileReader(pomXml);
    }
}
