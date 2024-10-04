package com.java.jpa.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee {

	private BigDecimal hourlyWage;
	
	private PartTimeEmployee() {
	}
	
	public PartTimeEmployee (String name,BigDecimal hourlyWage ) {
		super(name);
		this.hourlyWage = hourlyWage;
	}
}
