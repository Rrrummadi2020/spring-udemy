package com.example.firstproject.controller;

import com.example.firstproject.service.Car;
import com.example.firstproject.service.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Value("${coach.name}")
    private String name;

    private Coach myCoach;
    private Coach theCoach;

    private Car myCar;

    StudentController(@Qualifier("trackCoach") Coach coach,@Qualifier("trackCoach") Coach theCoach, Car car){
        this.myCoach = coach;
        this.myCar = car;
        this.theCoach = theCoach;
    }

    @GetMapping("/hello")
    public String getHello(){
        return name;
    }


    @GetMapping("/constructor-injection")
    public String getContructorInjectionWorking() {
        return this.myCoach.getDailyWorkout();
    }

    @GetMapping("/compone-nt-scan")
    public String checkComponentScan() {
        return this.myCar.getHorsePower();
    }

    @GetMapping("/singleton")
    public String singletonExample(){
        return "sigleton class will always have one instance throught the application "+(theCoach==myCoach);
    }
}
