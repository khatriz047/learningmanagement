package mum.cs544.service;

import java.util.List;

import mum.cs544.model.Answer;

public interface AnswerService {

	public Answer addAnswer(Answer answer);

	public List<Answer> getAllAnswer();

	public Answer getAnswerById(long id);

	void delete(long id);

}
