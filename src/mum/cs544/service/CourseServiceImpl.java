package mum.cs544.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mum.cs544.dao.CourseDao;
import mum.cs544.dao.FacultyDao;
import mum.cs544.dao.StudentDao;
import mum.cs544.model.Course;
import mum.cs544.model.Faculty;
import mum.cs544.model.Student;

@Service("courseService")
@Transactional(propagation = Propagation.REQUIRED)
public class CourseServiceImpl implements CourseService {

	@Resource
	private CourseDao courseDao;

	@Resource
	private FacultyDao facultyDao;

	@Resource
	private StudentDao studentDao;

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

	@Override
	public List<Course> getCourses(long facultyId) {
		Faculty faculty = facultyDao.findOne(facultyId);
		return courseDao.findByFaculty(faculty);
	}

	@Override
	public Course findById(long id) {
		return courseDao.findOne(id);
	}

	@Override
	public List<Course> findByIdIn(List<Long> ids) {
		return courseDao.findByIdIn(ids);
	}

	@Override
	public List<Course> findAllCoursesByStudent(String username) {

		Student student = studentDao.findByUsername(username);
		List<Course> courses = new ArrayList<>();
		for (Course course : student.getCourses()) {
			courses.add(course);
		}
		return courses;
	}

}
