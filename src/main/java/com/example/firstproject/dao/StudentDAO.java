package com.example.firstproject.dao;

import com.example.firstproject.entity.Student;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);
}
