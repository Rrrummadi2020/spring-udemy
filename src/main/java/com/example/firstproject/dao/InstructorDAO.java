package com.example.firstproject.dao;

import com.example.firstproject.entity.Instructor;

public interface InstructorDAO {
    void save(Instructor instructor);
    Instructor find(Integer id);
    void delete(Integer id);
}
