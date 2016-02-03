package mum.cs544.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import mum.cs544.utils.StringUtils;

@Entity
@DiscriminatorValue("PROFESSOR")
public class Professor extends User {

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "professor_course", joinColumns = { @JoinColumn(name = "professor_id") }, inverseJoinColumns = {
			@JoinColumn(name = "course_id") })
	private Set<Course> courses = new HashSet<>();

	@Transient
	private List<Long> coursesids = new ArrayList<>();

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public List<Long> getCoursesids() {
		return coursesids;
	}

	public void setCoursesids(List<Long> coursesids) {
		this.coursesids = coursesids;
	}

	public void addCourse(Course course) {
		this.courses.add(course);
	}

	public void addCourses(List<Course> courses) {
		this.courses.addAll(courses);
	}

}
