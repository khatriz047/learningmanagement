package mum.cs544.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mum.cs544.model.Question;

@Service("protalService")
@Transactional(propagation = Propagation.REQUIRED)
public interface PortalService {
	public Question postQuestion(Question question);
}
