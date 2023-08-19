package com.example.firstproject.controller;

import com.example.firstproject.service.Car;
import com.example.firstproject.service.Coach;
import com.example.firstproject.service.WeatherService;
import com.example.firstproject.service.impl.SwimCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StudentController {
    @Value("${coach.name}")
    private String name;

    private Coach myCoach;
    private Coach theCoach;

    private Car myCar;

    @Autowired
    private SwimCoach swimCoach;

    @Autowired
    private WeatherService weatherService;

    StudentController(@Qualifier("cricketCoach") Coach coach,@Qualifier("cricketCoach") Coach theCoach, Car car){
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
        return "prototype class will always have different instance for every request "+(theCoach==myCoach);
    }

    @RequestMapping(value = "/temperature", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getTemperature() {
        return weatherService.getWeatherInformation();
    }

    @GetMapping("/configured-bean")
    public String getSwimCoach() {
        return this.swimCoach.getDailyWorkout();
    }

}
