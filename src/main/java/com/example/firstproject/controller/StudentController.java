package com.example.firstproject.controller;

import com.example.firstproject.dao.StudentDAO;
import com.example.firstproject.entity.Student;
import com.example.firstproject.exception.StudentNotFound;
import com.example.firstproject.service.Car;
import com.example.firstproject.service.Coach;
import com.example.firstproject.service.WeatherService;
import com.example.firstproject.service.impl.SwimCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")//two ways to cross origin error handling
@RestController
@RequestMapping("/api")
public class StudentController {
    @Value("${coach.name}")
    private String name;

    private Coach myCoach;
    private Coach theCoach;

    private Car myCar;

    @Autowired
    public StudentDAO studentDAO;

    @Autowired
    private SwimCoach swimCoach;

    @Autowired
    private WeatherService weatherService;

    List<Student> theStudents;

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("st1", "sd", "s1@gmia.com"));
        theStudents.add(new Student("st2", "sd2", "s2@gmia.com"));
        theStudents.add(new Student("st3", "s3", "s2@gmia.com"));
    }

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

    @GetMapping("/student-exception/{studentId}")
    public Student getFromArray(@PathVariable Integer studentId) {

        if (studentId >= theStudents.size() || studentId < 0) {
             throw new StudentNotFound("Student not found");
        }
        return theStudents.get(studentId);
    }



}
