package mum.cs544.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mum.cs544.model.Course;
import mum.cs544.model.Faculty;
import mum.cs544.model.Professor;
import mum.cs544.service.CourseService;
import mum.cs544.service.FacultyService;
import mum.cs544.service.UserService;

@Controller
@RequestMapping(value = "/school")
public class SchoolController {

	@Autowired
	private FacultyService facultyService;

	@Autowired
	private CourseService courseService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/faculty", method = RequestMethod.GET)
	public String facultyPage(ModelMap model) {
		model.addAttribute("faculties", facultyService.getFaculties());
		model.addAttribute("faculty", new Faculty());
		return "faculty";
	}

	@RequestMapping(value = "/faculty", method = RequestMethod.POST)
	public String addFaculty(Faculty faculty) {

		facultyService.addFaculty(faculty);

		return "redirect:/school/faculty";
	}

	@RequestMapping(value = "/faculty/delete", method = RequestMethod.POST)
	public String deleteFaculty(@RequestParam("id") long id) {

		facultyService.delete(id);
		return "redirect:/school/faculty";
	}

	@RequestMapping(value = "/course", method = RequestMethod.GET)
	public String coursePage(ModelMap model) {
		model.addAttribute("courses", courseService.getCourses());
		model.addAttribute("course", new Course());
		return "course";
	}

	@RequestMapping(value = "/course", method = RequestMethod.POST)
	public String addCourse(Course course) {

		courseService.addCourse(course);

		return "redirect:/school/course";
	}

	@RequestMapping(value = "/course/delete", method = RequestMethod.POST)
	public String deleteCourse(@RequestParam("id") long id) {
		courseService.delete(id);
		return "redirect:/school/course";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String professorPage(ModelMap model) {
		model.addAttribute("professorUsers", userService.findAllProfessorUsers());
		model.addAttribute("professor", new Professor());
		return "userprofessor";
	}

	@RequestMapping(value = "/user/professor", method = RequestMethod.POST)
	public String addProfessor(Professor professorUser) {
		userService.addUser(professorUser);
		return "redirect:/school/user";
	}

	@RequestMapping(value = "/professor/activate", method = RequestMethod.POST)
	public String activateProfessor(@RequestParam("id") long id, @RequestParam("active") boolean active) {

		userService.activateUser(active, id);
		return "redirect:/school/user";
	}

}
