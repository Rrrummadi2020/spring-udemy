package com.example.firstproject.service.impl;

import com.example.firstproject.service.Coach;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class CricketCoach implements Coach {
    //with the above annotation place constructor logs will not appear untill explicity asked from the app context
    public CricketCoach(){
        System.out.println("In class"+ getClass().getName());
        System.out.println("in the console logs we can see the above word by default");
    }
    @Override
    public String getDailyWorkout() {
        return "Practice Daily 20 overs fast bowling";
    }
}
