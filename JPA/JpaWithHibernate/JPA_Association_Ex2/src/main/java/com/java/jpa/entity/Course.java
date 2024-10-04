package com.java.jpa.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@Entity
//@NamedQuery(name = "get_all_courses", query = "Select c from Course c") // for single namedquery
@NamedQueries(value = { @NamedQuery(name = "get_all_courses", query = "Select c from Course c"),
		@NamedQuery(name = "get all course hows_value_is_50", query = "Select c from Course c where c.name = 'Jpa in 3000 steps'") })
public class Course {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@OneToMany(mappedBy = "course") // this say -> one Course have many reviews
	private List<Review> reviews = new ArrayList<>();

	@UpdateTimestamp // this will give by the hibernate not JPA
	private LocalDateTime lastUpdateDate;

	@CreationTimestamp // this will also create provided by hibernate
	private LocalDateTime createDate;

	@ManyToMany(mappedBy = "courses") // Lazy fetching
	@JsonIgnore
	private List<Student> students = new ArrayList<>();

	public Course() {
	}

	public Course(String name) {
		super();
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void addStudents(Student student) {
		this.students.add(student);
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public LocalDateTime getLastUpdateDate() {
		return lastUpdateDate;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}

	public void removeReview(Review review) {
		this.reviews.remove(review);
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
