package com.example.firstproject.service.impl;

import com.example.firstproject.service.Coach;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice Daily 20 overs fast bowling";
    }
}
