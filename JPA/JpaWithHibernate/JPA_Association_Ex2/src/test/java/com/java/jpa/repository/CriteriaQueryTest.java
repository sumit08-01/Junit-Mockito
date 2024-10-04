package com.java.jpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.java.jpa.entity.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Transactional
@Slf4j
public class CriteriaQueryTest {

	@Autowired
	EntityManager em;

	@Test
	public void all_courses() {

		// select c from Course c --> we have to write this query using criteria query

		// 1-> Use criteria Builder to create a criteria query returning the expected
		// result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2-> Define roots for table which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3-> Define predicates etc using criteria Builder

		// 4 -> Add predicates etc to the criteria query

		// 5-> Build the typedQuery using the entity manager and criteria query

		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List resultList = query.getResultList();
		System.out.println("Typed Query with criteria Query : " + resultList);
	}

	@Test
	public void all_courses_having_100Steps() {

		// "select c from Course c where name like '%50 steps'" --> we have to write
		// this query using criteria query

		// 1-> Use criteria Builder to create a criteria query returning the expected
		// result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2-> Define roots for table which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3-> Define predicates etc using criteria Builder
		Predicate like50Steps = cb.like(courseRoot.get("name"), "%50 steps");
		// 4 -> Add predicates etc to the criteria query
		cq.where(like50Steps);
		// 5-> Build the typedQuery using the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List resultList = query.getResultList();
		System.out.println("Typed Query with criteria Query : " + resultList);
	}

	@Test
	public void all_courses_without_student() {

		// "select c from Course c where c.student is empty" --> we have to write
		// this query using criteria query

		// 1-> Use criteria Builder to create a criteria query returning the expected
		// result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2-> Define roots for table which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3-> Define predicates etc using criteria Builder
		Predicate studentIsEmpty = cb.isEmpty(courseRoot.get("students"));
		// 4 -> Add predicates etc to the criteria query
		cq.where(studentIsEmpty);
		// 5-> Build the typedQuery using the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List resultList = query.getResultList();
		System.out.println("Typed Query with criteria Query : " + resultList);
	}

	@Test
	public void join() {

		// "select c from Course c join c.student s " --> we have to write
		// this query using criteria query

		// 1-> Use criteria Builder to create a criteria query returning the expected
		// result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2-> Define roots for table which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3-> Define predicates etc using criteria Builder
		Join<Object, Object> join = courseRoot.join("students");

		// 4 -> Add predicates etc to the criteria query
		// 5-> Build the typedQuery using the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List resultList = query.getResultList();
		System.out.println("Typed Query with join criteria Query : " + resultList);
	}
	
	@Test
	public void leftjoin() {
		
		// "select c from Course c left join c.student s " --> we have to write
		// this query using criteria query
		
		// 1-> Use criteria Builder to create a criteria query returning the expected
		// result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		// 2-> Define roots for table which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);
		
		// 3-> Define predicates etc using criteria Builder
		Join<Object, Object> join = courseRoot.join("students", JoinType.LEFT);
		
		// 4 -> Add predicates etc to the criteria query
		// 5-> Build the typedQuery using the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List resultList = query.getResultList();
		System.out.println("Typed Query with left join criteria Query : " + resultList);
	}

}
