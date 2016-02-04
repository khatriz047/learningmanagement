package mum.cs544.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.cs544.model.Course;
import mum.cs544.model.Resource;
import mum.cs544.model.User;

public interface ResourceDao extends JpaRepository<Resource, Long> {
	
	List<Resource> findByUser(User user); 
	List<Resource> findByCourse(Course course);

}
