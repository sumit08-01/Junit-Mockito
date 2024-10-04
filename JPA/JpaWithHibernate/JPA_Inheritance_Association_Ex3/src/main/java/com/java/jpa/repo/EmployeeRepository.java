package com.java.jpa.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.jpa.entity.Employee;
import com.java.jpa.entity.FullTimeEmployee;
import com.java.jpa.entity.PartTimeEmployee;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmployeeRepository {

	@Autowired
	EntityManager entityManager;
	
	// insert into DB
	public void insert(Employee employee) {
		entityManager.persist(employee);
	}
	
	//RevieveAll Employee from DB
	public List<Employee> retrieveAllEmployee(){
		return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
	}
	public List<PartTimeEmployee> retrievePartAllEmployee(){
		return entityManager.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
	}
	public List<FullTimeEmployee> retrieveFullAllEmployee(){
		return entityManager.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
	}
}
