package com.java.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	@OneToOne(fetch = FetchType.LAZY)// this will give if we ask
	private Passport passport;
	
	@ManyToMany // this is owining this of this relationship and opposite side is mappedBy
	@JoinTable(name = "STUDENT_COURSE", 
	joinColumns = @JoinColumn(name = "STUDENT_ID"),
	inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))	
	private List<Course> courses = new ArrayList<>();

	public Student(String name) {
		super();
		this.name = name;
	}

	public Student() {
	}
	
	public List<Course> getCourses() {
		return courses;
	}

	public void addCourses(Course courses) {
		this.courses.add(courses);
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

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

}
