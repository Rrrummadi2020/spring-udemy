package com.example.firstproject;

import com.example.firstproject.dao.StudentDAO;
import com.example.firstproject.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"com.example.firstproject", "com.outside.service.impl"})
public class FirstprojectApplication {

	@Value("${server.port}")
	private String port;

	@Autowired
	private StudentDAO studentDAO;

	public static void main(String[] args) {
		SpringApplication.run(FirstprojectApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(String[] args) {
		return runner -> {
			System.out.println("Server started in POST 8081 ... " + port+" At: "+java.time.LocalTime.now());
//			createStudent();
			findStudent(2);
		};
	}

	public void  createStudent(){
		Student student = new Student("rama", "rangeswara", "rama@gmail.com");
		System.out.println("saving student");
		studentDAO.save(student);
		System.out.println("student saved to DB "+student.getId());

	}

	public void findStudent(Integer id) {
		System.out.println(studentDAO.findById(id));
	}
}
