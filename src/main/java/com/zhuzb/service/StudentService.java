package com.zhuzb.service;

import com.zhuzb.entity.Student;

import java.util.List;

public interface StudentService{
    public void saveStu(Student student);

    public List<Student> getList();
}
