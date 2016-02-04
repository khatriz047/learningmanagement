package mum.cs544.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.cs544.model.Course;
import mum.cs544.model.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {
	
	Student findByUsername(String username);

}
