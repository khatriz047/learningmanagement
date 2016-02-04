package mum.cs544.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mum.cs544.dao.AnswerDao;
import mum.cs544.model.Answer;
import mum.cs544.model.Question;
import mum.cs544.model.User;

@Service("answerService")
@Transactional(propagation = Propagation.REQUIRED)
public class AnswerServiceImpl implements AnswerService {

	@Resource
	private AnswerDao answerDao;

	@Override
	public Answer addAnswer(Answer answer) {
		return answerDao.save(answer);
	}

	@Override
	public List<Answer> getAllAnswer() {
		return answerDao.findAll();
	}

	@Override
	public Answer getAnswerById(long id) {
		return answerDao.findOne(id);
	}

	@Override
	public void delete(long id) {
		answerDao.delete(id);

	}

	@Override
	public void updateAnswerResult(long user_id, long question_id, long id) {
		answerDao.updateAnswerResult(user_id, question_id, id);
	}

	@Override
	public List<String> getEmailIDsFromCourses(long id) {
		return answerDao.getEmailIDsFromCourses(id);
	}


	/*@Override
	public void updateAnswerResult(User user, Question question, long id) {
		answerDao.updateAnswerResult(user, question, id);
		
	}*/

}
