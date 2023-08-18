package com.example.firstproject.service.impl;

import com.example.firstproject.service.Coach;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BaseballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "@qualifier annotation has more precedence compare to @Primary";
    }
}
