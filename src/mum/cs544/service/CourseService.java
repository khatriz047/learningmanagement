package mum.cs544.service;

import java.util.List;

import mum.cs544.model.Course;

public interface CourseService {

	Course addCourse(Course course);

	List<Course> getCourses();

	void delete(long id);

}
