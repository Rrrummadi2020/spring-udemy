package com.example.firstproject.service;

import java.util.List;

import com.example.firstproject.entity.Engineer;

public interface EngineerService {
    List<Engineer> findAll();
    Engineer findOneById(Integer id);
    void deleteById(Integer id);
    Engineer create(Engineer engineer);
}
