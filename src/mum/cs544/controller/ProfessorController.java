package mum.cs544.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mum.cs544.model.Faculty;
import mum.cs544.service.FacultyService;

@Controller
@RequestMapping(value = "/professor")
public class ProfessorController {

	@Autowired
	private FacultyService facultyService;

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String studentPage(ModelMap model) {
		return "student";
	}

	@RequestMapping(value = "/resource", method = RequestMethod.GET)
	public String resourcePage(ModelMap model) {
		return "resourceprofessor";
	}

	
}
