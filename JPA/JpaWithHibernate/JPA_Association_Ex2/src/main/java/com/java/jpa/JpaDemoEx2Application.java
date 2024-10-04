package com.java.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.java.jpa.entity.Course;
import com.java.jpa.entity.Student;
import com.java.jpa.repo.CourseRepository;
import com.java.jpa.repo.StudentRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
@Transactional
public class JpaDemoEx2Application implements CommandLineRunner {

	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoEx2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		studentRepository.saveStudentwithPassport();
//		courseRepository.addHardReviewToCourse();
		
//		List<Review> reviews = new ArrayList<>();
//		reviews.add( new Review("6", "Very very good"));
//		reviews.add( new Review("6", "Very Not good"));
//		
//		courseRepository.addReviewToCourse(10002L, reviews);
		
//		studentRepository.inserHardCodeStudentAndCourse();
//		studentRepository.inserStudentAndCourse(new Student("Priya"), new Course("AWS in 400000"));;
		
		
	}

}
