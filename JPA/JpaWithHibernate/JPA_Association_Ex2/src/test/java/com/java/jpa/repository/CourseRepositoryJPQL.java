package com.java.jpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.java.jpa.entity.Course;
import com.java.jpa.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Transactional
@Slf4j
public class CourseRepositoryJPQL {

	@Autowired
	EntityManager em;

	@Test
	public void courseTest() {
		Query query = em.createQuery("Select c from Course c"); // simple Querry
		List resultList = query.getResultList();
		System.out.println("Select c from Course c : " + resultList);
	}

	@Test
	public void courseTypeQuery() {
		TypedQuery<Course> createQuery = em.createQuery("Select c from Course c", Course.class);// typed query
		List<Course> resultList = createQuery.getResultList();
		System.out.println("Select c from Course c : with Typed Query" + resultList);

	}

	@Test
	public void courseTypeQueryWithCondition() {
		TypedQuery<Course> createQuery = em.createQuery("Select c from Course c where c.name = 'Jpa in 50 steps'",
				Course.class);// typed query
		List<Course> resultList = createQuery.getResultList();
		System.out.println("Select c from Course c : with Typed Query with condition " + resultList);

	}

	@Test
	public void courseTestWithNamedQuerry() {
		Query query = em.createNamedQuery("get_all_courses"); // NamedQuerry
		List resultList = query.getResultList();
		System.out.println("Select c from Course c : NamedQuery : " + resultList);
	}

	@Test
	public void courseTestWithNamedQuerries() {
		TypedQuery<Course> query = em.createNamedQuery("get all course hows_value_is_50", Course.class);// typed query
		List resultList = query.getResultList();
		System.out.println("Select c from Course c : Multiple Namedquery : " + resultList);
	}

	@Test
	public void Jpql_course_without_student() {
		TypedQuery<Course> query = em.createQuery("select c from Course c where c.students is empty", Course.class);// typed
																													// query
		List resultList = query.getResultList();
		System.out.println("select c from Course c where c.students is empty : Inheritance Query : " + resultList);
	}

	@Test
	public void Jpql_course_AtLeast_2_Student() {
		TypedQuery<Course> query = em.createQuery("select c from Course c where size(c.students) >=2", Course.class);// typed
																														// query
		List resultList = query.getResultList();
		System.out.println(
				"select c from Course c where size(c.students) >=2 : JPQL at least 2 students Query : " + resultList);
	}

	@Test
	public void Jpql_courses_OrderBy_Student() {
//		TypedQuery<Course> query = em.createQuery("select c from Course c order by size(c.students)", Course.class);// Ascending Order
		TypedQuery<Course> query = em.createQuery("select c from Course c order by size(c.students) desc",
				Course.class);// Descending Order
		List resultList = query.getResultList();
		System.out.println(
				"select c from Course c order by size(c.students): JPQL Order By Ascending & Descending Order By default Query : "
						+ resultList);
	}

	@Test
	public void Jpql_student_with_passport_inCertain_pattern() {
		TypedQuery<Student> query = em.createQuery("select s from Student s where s.passport.number like '%1234%'",
				Student.class);// Descending Order
		List<Student> resultList = query.getResultList();
		System.out.println("select s from student s where s.passport.number like %1234% : " + resultList);
	}

	/*
	 * LIKE \ BETWEEN 100 AND 1000 IS NULL UPPER, LOWER, TRIM, LENGTH
	 */

	// JOIN --> select c, s from Course c join c.students s
	// LEFT JOIN --> select c, s from Course c left join c.students s
	// CROSS JOIN --> select c, s from Course c , Student s
	@Test
	public void join() {
		Query query = em.createQuery("select c, s from Course c join c.students s");
		List<Object[]> resultList = query.getResultList();
		log.info("Result Size [] --> : " + resultList.size());
		for (Object[] result : resultList) {
			log.info("Courses{}, Students{}", result[0], result[1]);
		}
	}
	
	@Test
	public void left_join() {
		Query query = em.createQuery("select c, s from Course c left join c.students s");
		List<Object[]> resultList = query.getResultList();
		log.info("Result Size [] --> : " + resultList.size());
		for (Object[] result : resultList) {
			log.info("Courses{}, Students{}", result[0], result[1]);
		}
	}
	
	@Test
	public void cross_join() {
		Query query = em.createQuery("select c, s from Course c , Student s");
		List<Object[]> resultList = query.getResultList();
		log.info("Result Size [] --> : " + resultList.size());
		for (Object[] result : resultList) {
			log.info("Courses{}, Students{}", result[0], result[1]);
		}
	}
}
