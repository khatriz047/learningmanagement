package mum.cs544.service;

import java.util.List;

import mum.cs544.model.Answer;
import mum.cs544.model.Question;
import mum.cs544.model.User;

public interface AnswerService {

	public Answer addAnswer(Answer answer);

	public List<Answer> getAllAnswer();

	public Answer getAnswerById(long id);

	void delete(long id);

	void updateAnswerResult(long user_id,long question_id, long id);
	
	List<String> getEmailIDsFromCourses(long id);

}
