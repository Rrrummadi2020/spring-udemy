package com.example.firstproject;

import com.example.firstproject.dao.InstructorDAO;
import com.example.firstproject.dao.StudentDAO;
import com.example.firstproject.entity.Course;
import com.example.firstproject.entity.Instructor;
import com.example.firstproject.entity.InstructorDetail;
import com.example.firstproject.entity.Student;

import org.aspectj.apache.bcel.generic.Instruction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(scanBasePackages = {"com.example.firstproject", "com.outside.service.impl"})
public class FirstprojectApplication {

	@Value("${server.port}")
	private String port;

	@Autowired
	private StudentDAO studentDAO;

	@Autowired
	private InstructorDAO instructorDAO;

	public static void main(String[] args) {
		SpringApplication.run(FirstprojectApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(String[] args) {
		return runner -> {
			System.out.println("Server started in POST 8081 ... " + port+" At: "+java.time.LocalTime.now());
//			createStudent();
//			findStudent(2);
//			findByName("rama");
//			updateStudent();
//			deleteStudent();
			// createInstructorDetailsALongWithInstructor();
			// deleteInstructor();
			// findInstructorDetails();
			// deleteInstructorDetail();
			findInstructor();

		};
	}
	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200");
			}
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

	public void findByName(String name) {
		List<Student> slist = studentDAO.findByLastName(name);
		for (int i = 0; i < slist.size(); i++) {
			System.out.println(slist.get(i));
		}
	}

	public void updateStudent() {
		Student tempStudent = studentDAO.findById(1);
		tempStudent.setFirstName("chethan");
		studentDAO.updateStudent(tempStudent);
		System.out.println("updated student with id : " + tempStudent);
	}

	public void deleteStudent() {
		System.out.println("deleting id : ");
		studentDAO.delete(2);
		System.out.println("deleted student with id : ");
	}
	
	public void createInstructorDetailsALongWithInstructor() {
		Instructor tempInstructor = new Instructor("Jonas Schedmntan", "jonasschemetan@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("jonas@youtube.com", "Javascript Music tuner ");
		tempInstructor.setInstructorDetail(instructorDetail);
		tempInstructor.addCourse(new Course("React complete course", "Basic and adbanced concepts in "));
		tempInstructor
				.addCourse(new Course("Microservices Architecture with Java  Spring ", "Along withh the Docker hib"));
		System.out.println("saving Courses...");
		System.out.println("saving Insturctors...");
		instructorDAO.save(tempInstructor);
		System.out.println("done saving");
	}
	
	public void deleteInstructor() {
		System.out.println("deleting id : ");
		Integer instructorId = new Integer(1);
		instructorDAO.delete(instructorId);
		System.out.println("deleted student with id : 1");
	}

	public void findInstructorDetails(){
		 InstructorDetail instructorDetail =  instructorDAO.findInstructorDetail(3);
		 System.out.println(instructorDetail);
		 System.out.println(instructorDetail.getInstructor());
	}
	public void deleteInstructorDetail(){
		System.out.println("deleting the instructor detail ....");
		instructorDAO.deleteInstructorDetail(4);
		System.out.println("dleelted successfully ....");

	}
	
	public void findInstructor() {
		Instructor instructor = instructorDAO.find(9);
		System.out.println("courses lised in the below");
		System.out.println(instructor.getCourses());
System.out.println("instructore fourded");
		System.out.println(instructor.getInstructorDetail());
	}
}
