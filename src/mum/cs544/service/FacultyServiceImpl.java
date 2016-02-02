package mum.cs544.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mum.cs544.dao.FacultyDao;
import mum.cs544.model.Faculty;

@Service("facultyService")
@Transactional(propagation = Propagation.REQUIRED)

public class FacultyServiceImpl implements FacultyService {

	@Resource
	private FacultyDao facultyDao;

	@Override
	public Faculty addFaculty(Faculty faculty) {
		return facultyDao.save(faculty);
	}

	@Override
	public List<Faculty> getFaculties() {
		return facultyDao.findAll();
	}

	@Override
	public void delete(long id) {
		facultyDao.delete(id);
	}

}
