package mum.cs544.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.cs544.model.Question;

public interface PortalDao extends JpaRepository<Question, Long>{
	Question save(Question question);
}
