package mum.cs544.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mum.cs544.dao.AnswerDao;
import mum.cs544.dao.PortalDao;
import mum.cs544.model.Answer;
import mum.cs544.model.Question;

@Service("portalService")
@Transactional(propagation = Propagation.REQUIRED)
public class PortalServiceImpl implements PortalService {

	@Resource
	private PortalDao portalDao;

	@Resource
	private AnswerDao answerDao;

	@Override
	public Question postQuestion(Question question) {
		return portalDao.save(question);
	}

	@Override
	public List<Question> getAllQuestion() {
		return portalDao.findAll();
	}

	@Override
	public Answer postAnswer(Answer answer) {
		return answerDao.save(answer);
	}

	@Override
	public Question getQuestion(int id) {
		return portalDao.findById(id);
	}


}
