package com.example.firstproject.service.impl;

import com.example.firstproject.service.Coach;

public class SwimCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "you have to swim ten kilometers";
    }
}
