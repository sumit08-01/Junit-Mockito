package com.java.jpa.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.jpa.entity.Course;
import com.java.jpa.entity.Passport;
import com.java.jpa.entity.Student;

import jakarta.persistence.EntityManager;

@Repository
public class StudentRepository {

	@Autowired
	EntityManager entityManager;

	public Student findById(long id) {
		return entityManager.find(Student.class, 10001L);
	}

	public void deleteById(long id) {
		Student student = findById(id);
		entityManager.remove(student);
	}

	public Student saveStudent(Student student) {
		if (student.getId() == null) {
			entityManager.persist(student);
		} else {
			entityManager.merge(student);
		}
		return student;
	}

	public void saveStudentwithPassport() {
		Passport passport = new Passport("Z5634");
		entityManager.persist(passport);
		Student student = new Student();
		student.setName("Shivam");
		student.setPassport(passport);
		entityManager.persist(student);
	}

	public void inserHardCodeStudentAndCourse() {
		Student student = new Student("Rahul");
		Course course = new Course("Microservice in 10000000");

		entityManager.persist(student);
		entityManager.persist(course); //

		// Relation ship between them
		student.addCourses(course);
		course.addStudents(student);

		entityManager.persist(student); // because student is Owining side of this relationship
	}

	public void inserStudentAndCourse(Student student, Course course) {

		// Relation ship between them
		student.addCourses(course);
		course.addStudents(student);

		entityManager.persist(student);
		entityManager.persist(course); //
		
	}

}
