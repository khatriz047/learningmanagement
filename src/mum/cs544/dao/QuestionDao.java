package mum.cs544.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.cs544.model.Course;
import mum.cs544.model.Question;

public interface QuestionDao extends JpaRepository<Question, Long> {
	Question findById(Long id);
	
	List<Question> findByCourse(Course course);
}
