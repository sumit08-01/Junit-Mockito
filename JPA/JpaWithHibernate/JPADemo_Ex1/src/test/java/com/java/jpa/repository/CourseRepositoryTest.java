package com.java.jpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.java.jpa.entity.Course;
import com.java.jpa.repo.CourseRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
public class CourseRepositoryTest {

	@Autowired
	CourseRepository courseRepository;

	@Test
	public void courseTest() {
		assertEquals("Jpa in 50 steps", courseRepository.findById(10001).getName());
	}

	@Test
	@DirtiesContext
	public void deleteById() {
		courseRepository.deleteById(10002L);
		assertNull(courseRepository.findById(10002L));
	}

	@Test
	public void saveCourse() {
		assertEquals("Jpa in 50 steps", courseRepository.findById(10001).getName());

		Course course = courseRepository.findById(10001);
		course.setName("Jpa in 50 steps - updated");

		courseRepository.saveCourse(course);
		assertEquals("Jpa in 50 steps - updated", courseRepository.findById(10001).getName());

	}
	
}
