package com.example.firstproject.service.impl;

import com.example.firstproject.dao.EmployeeDAO;
import com.example.firstproject.entity.Employee;
import com.example.firstproject.service.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findOne(Integer id) {
        return employeeDAO.findOne(id);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Transactional
    @Override
    public String delete(Integer id) {
        employeeDAO.delete(id);
        return "Strudent Deleted with id"+id;
    }
}
