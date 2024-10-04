package com.java.jpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.java.jpa.entity.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
public class CourseRepositoryJPQL {

	@Autowired
	EntityManager em;
	
	@Test
	public void courseTest() {
		Query query = em.createQuery("Select c from Course c"); // simple Querry
		List resultList = query.getResultList();
		System.out.println("Select c from Course c : " +  resultList);
	}
	
	@Test
	public void courseTypeQuery() {
		TypedQuery<Course> createQuery = em.createQuery("Select c from Course c", Course.class);// typed query
		List<Course> resultList = createQuery.getResultList();
		System.out.println("Select c from Course c : with Typed Query" +  resultList);
		
	}
	
	@Test
	public void courseTypeQueryWithCondition() {
		TypedQuery<Course> createQuery = em.createQuery("Select c from Course c where c.name = 'Jpa in 50 steps'", Course.class);// typed query
		List<Course> resultList = createQuery.getResultList();
		System.out.println("Select c from Course c : with Typed Query with condition " +  resultList);
		
	}
	
	@Test
	public void courseTestWithNamedQuerry() {
		Query query = em.createNamedQuery("get_all_courses"); // NamedQuerry
		List resultList = query.getResultList();
		System.out.println("Select c from Course c : NamedQuery : " +  resultList);
	}
	
	@Test
	public void courseTestWithNamedQuerries() {
		 TypedQuery<Course> query = em.createNamedQuery("get all course hows_value_is_50", Course.class);// typed query
		List resultList = query.getResultList();
		System.out.println("Select c from Course c : Multiple Namedquery : " +  resultList);
	}
}
