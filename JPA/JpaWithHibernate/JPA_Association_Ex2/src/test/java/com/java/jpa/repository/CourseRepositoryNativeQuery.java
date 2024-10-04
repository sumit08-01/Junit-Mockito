package com.java.jpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.java.jpa.entity.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
public class CourseRepositoryNativeQuery {

	@Autowired
	EntityManager em;
	
	@Test
	public void courseTest() {
		Query query = em.createNativeQuery("Select * from Course "); // simple Native Querry
		List resultList = query.getResultList();
		System.out.println("Select * from Course  : Native query : " +  resultList);
	}
	@Test
	public void courseTestClass() {
		Query query = em.createNativeQuery("Select * from Course ", Course.class); //with class
		List resultList = query.getResultList();
		System.out.println("Select * from Course  : Native query with class : " +  resultList);
	}
	
	@Test
	public void nativeQuerywithParameters() {
		Query query = em.createNativeQuery("Select * from Course where id=? ", Course.class);
		query.setParameter(1, 10001L);
		List resultList = query.getResultList();
		System.out.println("Select * from Course  : Native query with positional parameters : " +  resultList);
	}
	
	@Test
	public void nativeQuerywithNamedParameter () {
		Query query = em.createNativeQuery("Select * from Course where :id ", Course.class);
		query.setParameter("id", 10001L);
		List resultList = query.getResultList();
		System.out.println("Select * from Course  : Native query with named parameter  : " +  resultList);
	}
	
	
}
