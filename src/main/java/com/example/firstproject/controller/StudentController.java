package com.example.firstproject.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Value("${coach.name}")
    private String name;

    @GetMapping("/hello")
    public String getHello(){
        return name;
    }
}
