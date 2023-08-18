package com.example.firstproject.service.impl;

import com.example.firstproject.service.Coach;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BaseballCoach implements Coach {
    public BaseballCoach(){
        System.out.println("In class "+ getClass().getName());
        System.out.println("if use @Lazy annotation in logs the above line will not appear");
    }
    @Override
    public String getDailyWorkout() {
        return "@qualifier annotation has more precedence compare to @Primary";
    }
}
