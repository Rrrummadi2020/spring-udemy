package com.example.firstproject.dao;

import java.util.List;

import com.example.firstproject.entity.Course;
import com.example.firstproject.entity.Instructor;
import com.example.firstproject.entity.InstructorDetail;
import com.example.firstproject.entity.Student;

public interface InstructorDAO {
    void save(Instructor instructor);
    Instructor find(Integer id);
    void delete(Integer id);
    InstructorDetail findInstructorDetail(Integer id);
     void deleteInstructorDetail(Integer id); 
     List<Course> findCoursesByInstructorId(Integer id);
     Instructor findInstructorsByJoinFetch(Integer id);
     void updateInstructor(Instructor instructor);
     void saveCourse(Course course);
     Course findOneCourse(Integer id);
     void deleteCourse(Integer id);
     Course findCourse(Integer id);
     Course findCourseWithStudents(Integer id);
     Student findStudentWithCourses(Integer id);
}
