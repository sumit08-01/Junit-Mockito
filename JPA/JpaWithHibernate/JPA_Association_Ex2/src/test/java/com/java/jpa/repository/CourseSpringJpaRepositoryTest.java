package com.java.jpa.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.java.jpa.entity.Course;
import com.java.jpa.repo.CourseSpringDataRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class CourseSpringJpaRepositoryTest {

	@Autowired
	CourseSpringDataRepository repository;
	
	@Test
	public void findByIdIsPresent() {
		Optional<Course> course = repository.findById(10001L);
		log.info("Course --> True : " + course.isPresent());
		assertTrue(course.isPresent());
	}
	@Test
	public void findByIdIsFalse() {
		Optional<Course> course = repository.findById(1001L);
		log.info("Course --> False : " + course.isPresent());
		assertFalse(course.isPresent());
	}
	
	@Test
	public void sortCourses() {
//		Sort sort = new Sort(Sort.Direction.DESC, "name").and(sort); // sort on the basic of name in descending order and other sortform
//		log.info("Sorted Courses : ---> " + repository.findAll(sort));
	}
	
	@Test
	public void pagination() {
		PageRequest pageRequest = PageRequest.of(0, 3);// 0-> 1st page, 3 -> Hom many content, here 3 content in 1st page
		log.info("1st page with 3 content on it : --> " + repository.findAll(pageRequest).getContent());
		
		Pageable pageable = pageRequest.next();
		log.info("2st page with 3 content on it : --> " + repository.findAll(pageable).getContent());

	}
	
	@Test
	public void findByName() {
		List<Course> course = repository.findByName("Dummy1");
		log.info("Course Using Custome query findByName : --> " + course);
	}
}
