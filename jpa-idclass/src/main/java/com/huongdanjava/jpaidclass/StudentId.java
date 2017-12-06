package com.huongdanjava.jpaidclass;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
public class StudentId implements Serializable {

    private Integer id;

    private Integer code;

}
