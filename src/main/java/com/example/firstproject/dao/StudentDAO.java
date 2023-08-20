package com.example.firstproject.dao;

import com.example.firstproject.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);

    List<Student> findByLastName(String lastName);

    void updateStudent(Student updatedStud);

    void delete(Integer id);
}
