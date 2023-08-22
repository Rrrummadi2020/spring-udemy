package com.example.firstproject.dao;

import com.example.firstproject.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findOne(Integer id);

    Employee save(Employee employee);

    void delete(Integer id);

}
