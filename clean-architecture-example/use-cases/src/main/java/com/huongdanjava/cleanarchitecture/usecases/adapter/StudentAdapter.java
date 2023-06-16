package com.huongdanjava.cleanarchitecture.usecases.adapter;

import com.huongdanjava.cleanarchitecture.entities.Student;

public interface StudentAdapter {

  Student findByName(String name);
}
