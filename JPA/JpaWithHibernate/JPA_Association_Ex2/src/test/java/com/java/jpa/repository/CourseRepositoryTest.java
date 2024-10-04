package com.java.jpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.contains;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.java.jpa.entity.Course;
import com.java.jpa.entity.Review;
import com.java.jpa.repo.CourseRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Transactional
@Slf4j
public class CourseRepositoryTest {

	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	EntityManager entityManager;

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

	@Test
	@Transactional
	public void reteriveReviewForCourse() {
		Course course = courseRepository.findById(10001);
		log.info("Review : --> " + course.getReviews());

	}
	
	@Test
	public void reteriveCourseForReview() {
		Review review = entityManager.find(Review.class, 50001);
		log.info("Course -->>>>> : __--> " + review.getCourse() );
	}
	
	@Test
	@Transactional
	public void firstLevelCacheCourseRepo() {
		String course1 = courseRepository.findById(10001).getName();
		log.info("first course reterive : ---> " + course1);
		String course2 = courseRepository.findById(10001).getName();
		log.info("first course reterive again  : ---> " + course2);
		assertEquals("Jpa in 50 steps", course1);
	}

}
