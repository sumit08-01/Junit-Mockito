package com.java.jpa;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.java.jpa.entity.FullTimeEmployee;
import com.java.jpa.entity.PartTimeEmployee;
import com.java.jpa.repo.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class JpaDemoEx1Application implements CommandLineRunner {

	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoEx1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * employeeRepository.insert(new FullTimeEmployee("Sumit", new
		 * BigDecimal(500))); employeeRepository.insert(new PartTimeEmployee("Yogi", new
		 * BigDecimal(600)));
		 * 
		 * // log.info("Employee Details : ---> " +
		 * employeeRepository.retrieveAllEmployee());
		 * log.info("Part Time Employee Details : ---> " +
		 * employeeRepository.retrievePartAllEmployee());
		 * log.info("Full Time Employee Details : ---> " +
		 * employeeRepository.retrieveFullAllEmployee());
		 */
	}

}
