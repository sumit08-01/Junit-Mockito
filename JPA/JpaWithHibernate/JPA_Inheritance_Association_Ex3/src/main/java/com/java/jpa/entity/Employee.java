package com.java.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass // this class is not associated with entity but it's subclasses can
//@Entity
//@Inheritance(strategy = InheritanceType.JOINED) // In this all classes have it's own table, and retrieve details perform on JOINED basis
public abstract class Employee { // abstract because I don't want to any one make object of this class

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	public Employee() {
	}

	public Employee(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}

}
