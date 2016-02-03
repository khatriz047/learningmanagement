package mum.cs544.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mum.cs544.model.Professor;
import mum.cs544.service.UserService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/resource", method = RequestMethod.GET)
	public String resourcePage(ModelMap model) {
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
