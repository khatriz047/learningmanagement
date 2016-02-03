package mum.cs544.service;

import java.util.List;

import mum.cs544.model.QueuedEmail;

public interface QueuedEmailService {

	QueuedEmail addEmail(QueuedEmail email);

	List<QueuedEmail> getAll();

	List<QueuedEmail> findByType(String type);

	List<QueuedEmail> findByStatus(int status);

}
