package com.java.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.java.jpa.entity.Course;
import com.java.jpa.repo.CourseRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
@Transactional
public class JpaDemoEx1Application implements CommandLineRunner {

	@Autowired
	CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoEx1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course findById = courseRepository.findById(10001L);
		System.out.println(findById.toString());

//		courseRepository.deleteById(10001L);

//		courseRepository.saveCourse(new Course("Microservices in 50 steps"));
		courseRepository.playWithEntityManager();

	}

}
