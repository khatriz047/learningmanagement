package mum.cs544.service;

import java.util.List;
import java.util.Map;

import mum.cs544.model.Course;

public interface CourseService {

	Course addCourse(Course course);

	List<Course> getCourses();

	void delete(long id);
	
	public List<Course> getCourses(long facultyId);
	
	Course findById(long id);
	
	List<Course> findByIdIn(List<Long> ids);
	

}
