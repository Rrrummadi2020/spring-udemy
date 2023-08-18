package com.example.firstproject.service.impl;

import com.example.firstproject.service.Coach;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "@Qualifier was used in the usage place & @Primary used in the bean defination";
    }
}
