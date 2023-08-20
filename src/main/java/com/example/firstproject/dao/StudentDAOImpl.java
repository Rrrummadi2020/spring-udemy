package com.example.firstproject.dao;

import com.example.firstproject.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {
    //repository sub-type of component ,used to translate the exceptions from checked to unchecked JDBC steps
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Transactional
    @Override
    public void save(Student student) {
        //transaction is used to start and end the code , commit the transaction all do itself , no need to write extra code , then annotation not necessary for queries
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id){
        return entityManager.find(Student.class,id);
    }
}
