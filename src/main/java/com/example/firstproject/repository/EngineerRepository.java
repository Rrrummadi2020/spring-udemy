package com.example.firstproject.repository;

import com.example.firstproject.entity.Engineer;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineerRepository extends JpaRepository<Engineer, Integer> {
    
}
