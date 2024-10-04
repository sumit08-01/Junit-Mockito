package com.java.jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.java.jpa.entity.Passport;
import com.java.jpa.entity.Student;
import com.java.jpa.repo.StudentRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Transactional
@Slf4j
public class StudentRepositoryTest {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	EntityManager entityManager;

	@Test
	@Transactional
	public void reteriveStudentAndPassportDetails() {
		Student student = entityManager.find(Student.class, 20001L);
		System.out.println(student.toString());
		System.out.println(student.getPassport().toString());
	}
	
	@Test
	public void reterivePassportAndAssociatedStudent() {
		Passport passport = entityManager.find(Passport.class, 40001L);
		System.out.println("Passport Details : --> " + passport.toString());
		System.out.println("Student Details : --> " + passport.getStudent());
	}
	
	@Test
	public void reteriveStudentAndCourses() { 
		Student student = entityManager.find(Student.class, 20001L);
		log.info("Student ----->    : ---> " +  student);
		log.info("courses ----->    : ---> " +  student.getCourses());
	
	}

}
