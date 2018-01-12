package com.zhuzb.dao;

import com.zhuzb.entity.Student;
import com.zhuzb.util.Pager;

import java.util.List;

public interface StudentDao {
    public void saveStudent(Student student);

    public List<Student> getStu();
}
