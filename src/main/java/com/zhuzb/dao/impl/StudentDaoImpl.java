package com.zhuzb.dao.impl;

import com.zhuzb.dao.StudentDao;
import com.zhuzb.entity.Student;
import com.zhuzb.util.Pager;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl extends BaseDaoImpl implements StudentDao{

    @Override
    public void saveStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
    }

    @Override
    public List<Student> getStu(){
        List<Student> stuList = getAll(Student.class);
        return stuList;
    }
}
