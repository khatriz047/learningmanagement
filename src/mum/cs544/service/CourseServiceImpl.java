package mum.cs544.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mum.cs544.dao.CourseDao;
import mum.cs544.model.Course;

@Service("courseService")
@Transactional(propagation = Propagation.REQUIRED)
public class CourseServiceImpl implements CourseService {

	@Resource
	private CourseDao courseDao;

	@Override
	public Course addCourse(Course course) {
		return courseDao.save(course);
	}

	@Override
	public List<Course> getCourses() {
		return courseDao.findAll();
	}

	@Override
	public void delete(long id) {
		courseDao.delete(id);

	}

}
