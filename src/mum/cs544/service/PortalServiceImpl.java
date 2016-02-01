package mum.cs544.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import mum.cs544.dao.PortalDao;
import mum.cs544.model.Question;

@Service
@Transactional
public class PortalServiceImpl implements PortalService {

	@Resource
	private PortalDao portalDao;
	@Override
	public Question postQuestion(Question question) {
		return portalDao.save(question);
	}

}
