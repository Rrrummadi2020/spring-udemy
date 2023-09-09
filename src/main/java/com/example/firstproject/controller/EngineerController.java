package com.example.firstproject.controller;

import com.example.firstproject.entity.Employee;
import com.example.firstproject.entity.Engineer;
import com.example.firstproject.service.EmployeeService;
import com.example.firstproject.service.EngineerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EngineerController {


    private EngineerService engineerService;

    @Autowired
    public EngineerController(EngineerService engineerService) {
        this.engineerService = engineerService;
    }
    @GetMapping("/engineers")
    public List<Engineer> findAllEngineers(){
        return this.engineerService.findAll();
    }
    
    @GetMapping("/engineers/{id}")
    public Engineer findAllEngineersById(@PathVariable Integer id) {
        return this.engineerService.findOneById(id);
    }

    @PostMapping("/engineers")
    public Engineer createNewStudent(@RequestBody Engineer engineer){
        return engineerService.create(engineer);
    }
    @DeleteMapping("/engineers/{id}")
    public void deleteEmployee(@PathVariable Integer id){
        engineerService.deleteById(id);
    } 
}
