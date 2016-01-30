package mum.cs544.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.cs544.service.UserService;

@Controller
public class AdminController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/admin/school", method = RequestMethod.GET)
	public String schoolPage(ModelMap model) {
		return "school";
	}

	@RequestMapping(value = "/admin/role", method = RequestMethod.GET)
	public String rolePage(ModelMap model) {
		return "role";
	}

	@RequestMapping(value = "/admin/user", method = RequestMethod.GET)
	public String userPage(ModelMap model) {
		return "user";
	}


}
