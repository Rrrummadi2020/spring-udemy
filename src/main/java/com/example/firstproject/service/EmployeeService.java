package com.example.firstproject.service;

import com.example.firstproject.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findOne(Integer id);

    Employee save(Employee employee);

    String delete(Integer id);
}
