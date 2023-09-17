package com.example.firstproject.dao;

import org.springframework.stereotype.Repository;

import com.example.firstproject.entity.Instructor;
import com.example.firstproject.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
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
        Instructor instructor2 = entityManager.find(Instructor.class,1);
        entityManager.remove(instructor2);
    }
    @Override
    public Instructor find(Integer id) {
        // TODO Auto-generated method stub
        return entityManager.find(Instructor.class, id);
    }
    public InstructorDetail findInstructorDetail(Integer id){
        return entityManager.find(InstructorDetail.class, id);
    }
    @Transactional
    public void deleteInstructorDetail(Integer id){
        InstructorDetail instructorDetail =  entityManager.find(InstructorDetail.class, id);
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);
    }
}
