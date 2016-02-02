package mum.cs544.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.cs544.model.Course;

public interface CourseDao extends JpaRepository<Course, Long> {

}
