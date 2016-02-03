package mum.cs544.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.cs544.model.Course;
import mum.cs544.model.Faculty;

public interface CourseDao extends JpaRepository<Course, Long> {

	List<Course> findByFaculty(Faculty faculty);

	List<Course> findByIdIn(List<Long> ids);

}
