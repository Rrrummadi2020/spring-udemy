package com.example.firstproject.service.impl;

import com.example.firstproject.service.Coach;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class TrackCoach implements Coach {
    //with the above annotation place constructor  logs will not appear untill explicity asked from the app context
    public TrackCoach(){
        System.out.println("In class "+ getClass().getName());
        System.out.println("can use @Lazy annotation for a class level spring.main.lazy-iniialization=true in the application prop file set up");
    }

    @Override
    public String getDailyWorkout() {
        return "@Qualifier was used in the usage place & @Primary used in the bean defination";
    }
}
