package mum.cs544.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SchoolController {

	@RequestMapping(value = "/school/faculty", method = RequestMethod.GET)
	public String schoolPage(ModelMap model) {
		return "faculty";
	}

}
