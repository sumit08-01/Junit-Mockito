package com.java.jpa.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.jpa.entity.Course;

import jakarta.persistence.EntityManager;

@Repository
public class CourseRepository {

	@Autowired
	EntityManager entityManager;

	public Course findById(long id) {
		return entityManager.find(Course.class, 10001L);
	}

	public void deleteById(long id) {
		Course course = findById(id);
		entityManager.remove(course);
	}

	public Course saveCourse(Course course) {
		if (course.getId() == null) {
			entityManager.persist(course);
		} else {
			entityManager.merge(course);
		}
		return course;
	}
	
	public void playWithEntityManager() {
//		Course course1 = new Course("Web services in 100 steps");
//		entityManager.persist(course1);
//		
//		Course course2 = new Course("Angular JS in 100 steps");
//		entityManager.persist(course2);
//		
//		entityManager.flush(); // before this all change commit to databases, save to databases
//		
////		entityManager.detach(course2); // at this line course2 is detach mean no longer managed by entity manager
//		course2.setName("Angular JS in 100 steps -- update"); // this will not update 
//		course1.setName("Web services in 100 steps - updated"); // but this will updated
//		
////		entityManager.flush(); // if we uncomment this line, then changes reflected to databses and not to refresh
//		course2.setName("Angular JS in 50000 steps -- update");
//		entityManager.refresh(course2); // this will not refresh and last change
////		entityManager.clear(); // detach all managed entities
		
		// for current date and time 
		Course course1 = new Course("Web services in 100 steps");
		entityManager.persist(course1);
		
		Course course2 = findById(10001L);
		course2.setName("Jpa in 50 steps - updated");
	}
}
