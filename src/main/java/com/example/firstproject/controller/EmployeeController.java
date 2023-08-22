package com.example.firstproject.controller;

import com.example.firstproject.entity.Employee;
import com.example.firstproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {


    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @PostMapping("/")
    public Employee createStudent(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }
}
