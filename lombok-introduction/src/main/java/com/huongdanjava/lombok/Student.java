package com.huongdanjava.lombok;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String name;

    @Getter
    @Setter
    private String code;

    private Date dateOfBirth;

    public Student(String name) {
        this.name = name;
    }

}