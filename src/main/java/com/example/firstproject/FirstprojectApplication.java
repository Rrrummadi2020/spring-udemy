package com.example.firstproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.firstproject.dao.InstructorDAO;
import com.example.firstproject.dao.StudentDAO;
import com.example.firstproject.entity.Course;
import com.example.firstproject.entity.Instructor;
import com.example.firstproject.entity.InstructorDetail;
import com.example.firstproject.entity.Review;
import com.example.firstproject.entity.Student;

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
			// findCourseWithStudents();
			// findStudentWithCourses();
			//			createStudent();
//			findStudent(2);
//			findByName("rama");
//			updateStudent();
			// deleteStudent();
			// createInstructorDetailsALongWithInstructor();
			// deleteInstructor();
			// findInstructorDetails();
			// deleteInstructorDetail();
			// findInstructor();
			// findInstructorWithJoinFetch();
			// updateInstructorExisting();
			// updateCourse();
			// deleteCourse();
			// findCourse();
		};
	}
	
	private void findCourseWithStudents() {
		Course course =  instructorDAO.findCourseWithStudents(11);
		System.out.println("following are the course data alone............ ");
		System.out.println(course);
		System.out.println("following are the students of the particular course......");
		System.out.println(course.getStudents());
		System.out.println("done fetching the course wth list of studets............ ");
		Student student = new Student("Sairam","IIIterator","sairam@rgukt.com");
		Student studenttwo = new Student("Amar","Nath","amarnathp@mits.com");
		course.addStudent(student);
		course.addStudent(studenttwo);
		System.out.println("saving course........");
		instructorDAO.updateCourse(course);
		System.out.println("done  course saved ........");
	}
	
	private void findStudentWithCourses() {
		Student student = instructorDAO.findStudentWithCourses(7);
		System.out.println("following are the student data alone............ ");
		System.out.println(student);
		System.out.println("following are the courses of the particular Student......");
		System.out.println(student.getCourses());
		System.out.println("done fetching the student  wth list of courses............ ");
	}

	private void findInstructorWithJoinFetch() {
		Instructor instructor = instructorDAO.findInstructorsByJoinFetch(9);
		System.out.println("data fetch completed & showing the courses");
		System.out.println(instructor.getCourses());
		System.out.println("getting instructors");
		System.out.println(instructor.getInstructorDetail());
		System.out.println("done....");
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
		studentDAO.delete(10);
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
		Integer instructorId = new Integer(9);
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
		List<Course> courses =  instructorDAO.findCoursesByInstructorId(9);
		instructor.setCourses(courses);
		System.out.println("fourded courses in the below");
		System.out.println(instructor.getCourses());//this line will throw an error
		System.out.println("instructore founded");
		System.out.println(instructor.getInstructorDetail());
	}
	public void updateInstructorExisting(){
		Instructor instructor =  instructorDAO.find(9);
		instructor.setName("Renuka Krishna kourshik");
		System.out.println("updateing ....");
		instructorDAO.updateInstructor(instructor);
		System.out.println("done.....");
	}

	public void updateCourse() {
		Course course = new Course("Date Stuructures and algorithms", "sANDEEP jAIN gfgs");
		Review review = new Review("eXCELLENET ");
		Review review2 = new Review("very excellent");
		course.addReview(review);
		course.addReview(review2);
		Student studentOne = new Student("Mani","Kanta","manikanta@gmail.com");
		Student studentTwo = new Student("Neela","React","neela@gmail.com");
		course.addStudent(studentOne);
		course.addStudent(studentTwo);
		instructorDAO.updateCourse(course);
	}

	public void deleteCourse() {
		System.out.println("deleteing the courses and their review  due to cascade ");
		instructorDAO.deleteCourse(11);
	}

	public void findCourse() {
		System.out.println("fetching the courses and their review due to cascade ");
		Course course = instructorDAO.findCourse(5);
		System.out.println(course.getReviews());

	}

}
