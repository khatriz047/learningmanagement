package mum.cs544.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mum.cs544.model.Professor;
import mum.cs544.model.Resource;
import mum.cs544.model.User;
import mum.cs544.service.CourseService;
import mum.cs544.service.ResourceService;
import mum.cs544.service.UserService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private ResourceService resourceService;

	@Autowired
	private UserService userService;
	@Autowired
	private CourseService courseService;

	@RequestMapping(value = "/resource", method = RequestMethod.GET)
	public String resourcePage(ModelMap model, HttpSession session) {
		String username = (String) session.getAttribute("username");

		model.addAttribute("resource", new Resource());
		model.addAttribute("coursesMap", courseService.findAllCoursesByStudent(username));
		return "studentresource";
	}

	@RequestMapping(value = "/resource/{id}", method = RequestMethod.GET)
	public String resourcePage(@PathVariable long id, ModelMap model, HttpSession session) {
		String username = (String) session.getAttribute("username");

		model.addAttribute("resources", resourceService.findByCourse(id));
		model.addAttribute("resource", new Resource());
		model.addAttribute("coursesMap", courseService.findAllCoursesByStudent(username));
		return "studentresource";
	}

	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public String messagePage(ModelMap model) {
		return "studentmessage";
	}

	@RequestMapping(value = "/discussion", method = RequestMethod.GET)
	public String discussionPage(ModelMap model) {
		return "studentdiscussion";
	}

}
