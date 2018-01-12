package com.zhuzb.service.impl;

import com.zhuzb.dao.StudentDao;
import com.zhuzb.entity.Student;
import com.zhuzb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    //@Transactional(readOnly = false,propagation = Propagation.REQUIRED)
    public void saveStu(Student student) {
        studentDao.saveStudent(student);
    }

    @Override
    public List<Student> getList() {
        return studentDao.getStu();
    }
}
