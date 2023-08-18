package com.example.firstproject.service.impl;

import com.example.firstproject.service.Coach;

public class BaseballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "@qualifier annotation has more precedence compare to @Primary";
    }
}
