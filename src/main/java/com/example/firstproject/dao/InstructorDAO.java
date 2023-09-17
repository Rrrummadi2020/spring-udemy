package com.example.firstproject.dao;

import com.example.firstproject.entity.Instructor;
import com.example.firstproject.entity.InstructorDetail;

public interface InstructorDAO {
    void save(Instructor instructor);
    Instructor find(Integer id);
    void delete(Integer id);
    InstructorDetail findInstructorDetail(Integer id);
     void deleteInstructorDetail(Integer id); 
}
