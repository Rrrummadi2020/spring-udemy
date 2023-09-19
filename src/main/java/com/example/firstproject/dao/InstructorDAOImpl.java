package com.example.firstproject.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.firstproject.entity.Course;
import com.example.firstproject.entity.Instructor;
import com.example.firstproject.entity.InstructorDetail;
import com.example.firstproject.entity.Review;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class InstructorDAOImpl implements InstructorDAO {
    private EntityManager entityManager;

    public InstructorDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        Instructor instructor2 = entityManager.find(Instructor.class, id);
        List<Course> courses =  instructor2.getCourses();
        for (Course course : courses) {
            course.setInstructor(null);
        }
        entityManager.remove(instructor2);
    }

    @Override
    public Instructor find(Integer id) {
        // TODO Auto-generated method stub
        return entityManager.find(Instructor.class, id);
    }

    public InstructorDetail findInstructorDetail(Integer id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Transactional
    public void deleteInstructorDetail(Integer id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(Integer id) {
        // TODO Auto-generated method stub
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id=:theID", Course.class);
        query.setParameter("theID",id);
        List<Course> courses = query.getResultList();
        return courses;
    }
    
    @Override
    public Instructor findInstructorsByJoinFetch(Integer id) {
        TypedQuery<Instructor> query = entityManager
                .createQuery("SELECT i from Instructor i JOIN FETCH i.courses JOIN FETCH i.instructorDetail where i.id=:theID", Instructor.class);
        query.setParameter("theID", id);
        Instructor instructor = query.getSingleResult();
        return instructor;
    }
    @Override
    @Transactional
    public void updateInstructor(Instructor instructor){
        entityManager.merge(instructor);
    }
    
    public Course findOneCourse(Integer id){
        Course course =  entityManager.find(Course.class,id);
        return course;
    }    
    
    @Override
    @Transactional
    public void saveCourse(Course course) {
        entityManager.persist(course);
    }
    @Override
    @Transactional
    public void deleteCourse(Integer id) {
        // TODO Auto-generated method stub
        Course course = entityManager.find(Course.class,  id);
        entityManager.remove(course);

    }
    @Override
    public Course findCourse(Integer id){
        TypedQuery<Course> query = entityManager.createQuery("SELECT i FROM Course i JOIN FETCH i.reviews WHERE i.id=:theID", Course.class);
        query.setParameter("theID", id);
        return query.getSingleResult();
    }
}
