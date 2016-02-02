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
@RequestMapping(value = "/school")
public class SchoolController {

	@Autowired
	private FacultyService facultyService;

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
	public String deleteRole(@RequestParam("id") long id) {

		facultyService.delete(id);
		return "redirect:/school/faculty";
	}

}
