package mum.cs544.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import mum.cs544.model.Answer;

public interface AnswerDao extends JpaRepository<Answer, Long>{
	Answer save(Answer answer);
}
