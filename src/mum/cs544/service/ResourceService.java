package mum.cs544.service;

import java.util.List;

import mum.cs544.model.Course;
import mum.cs544.model.Resource;

public interface ResourceService {

	Resource addResource(Resource resource);

	List<Resource> getResources();

	void delete(long id);
	
	List<Resource> findByCourse(long id);

}
