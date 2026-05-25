package com.fudn.chapter2_ex1.services;

import com.fudn.chapter2_ex1.pojos.Student;

public class StudentServiceImpl implements StudentService {
    @Override
    public void save(Student student){
        System.out.println("Save student...");
    }
}
