package com.java.jpa.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
//@NamedQuery(name = "get_all_courses", query = "Select c from Course c") // for single namedquery
@NamedQueries(value = { @NamedQuery(name = "get_all_courses", query = "Select c from Course c"),
		@NamedQuery(name = "get all course hows_value_is_50", query = "Select c from Course c where c.name = 'Jpa in 3000 steps'") })
public class Course {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@UpdateTimestamp // this will give by the hibernate not JPA
	private LocalDateTime lastUpdateDate;

	@CreationTimestamp // this will also create provided by hibernate
	private LocalDateTime createDate;

	public Course() {
	}

	public Course(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + "]";
	}

}
