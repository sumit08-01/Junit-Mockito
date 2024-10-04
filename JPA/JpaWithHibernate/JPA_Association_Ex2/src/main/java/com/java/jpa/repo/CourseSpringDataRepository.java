package com.java.jpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.java.jpa.entity.Course;

@RepositoryRestResource(path = "/courses")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {

	List<Course> findByName(String name);

	List<Course> findByNameAndId(String name, Long id);

	List<Course> countByName(String name);

	List<Course> findByNameOrderByIdDesc(String name);

	List<Course> deleteByName(String name);

//	@Query("select c From Course c where name like '%50 Steps'")
//	List<Course> courseWith50Steps(String name);
//
//	@Query(value = "select * From Course c where name like '%50 Steps'", nativeQuery = true)
//	List<Course> courseWith50StepsWithNative(String name);
//
//	@Query(name = "query_get_50_Step_courses")
//	List<Course> courseWith50StepsWithNamedQuery(String name);

}
