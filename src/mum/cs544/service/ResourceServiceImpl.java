package mum.cs544.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mum.cs544.dao.ResourceDao;
import mum.cs544.model.Resource;

@Service("resourceService")
@Transactional(propagation = Propagation.REQUIRED)
public class ResourceServiceImpl implements ResourceService {

	@javax.annotation.Resource
	private ResourceDao resourceDao;

	@Override
	public Resource addResource(Resource resource) {
		return resourceDao.save(resource);
	}

	@Override
	public List<Resource> getResources() {
		return resourceDao.findAll();
	}

	@Override
	public void delete(long id) {
		resourceDao.delete(id);
	}

}
