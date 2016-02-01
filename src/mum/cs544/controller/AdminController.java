package mum.cs544.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mum.cs544.model.Role;
import mum.cs544.model.User;
import mum.cs544.service.RoleService;
import mum.cs544.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;

	@RequestMapping(value = "/school", method = RequestMethod.GET)
	public String schoolPage(ModelMap model) {
		model.addAttribute("schoolUsers", userService.findAllUsers());
		model.addAttribute("schoolUser", new User());
		return "school";
	}

	@RequestMapping(value = "/school", method = RequestMethod.POST)
	public String addSchool(User schoolUser) {
		userService.addSchoolUser(schoolUser);
		return "redirect:/admin/school";
	}

	@RequestMapping(value = "/role", method = RequestMethod.GET)
	public String rolePage(ModelMap model) {
		model.addAttribute("roles", roleService.getRoles());
		model.addAttribute("role", new Role());
		return "role";
	}

	@RequestMapping(value = "/role", method = RequestMethod.POST)
	public String addRole(Role role) {

		roleService.addRole(role);

		return "redirect:/admin/role";
	}

	@RequestMapping(value = "/role/delete", method = RequestMethod.POST)
	public String deleteRole(@RequestParam("id") long id) {

		roleService.delete(id);
		return "redirect:/admin/role";
	}

	@RequestMapping(value = "/school/activate", method = RequestMethod.POST)
	public String activateSchool(@RequestParam("id") long id, @RequestParam("active") boolean active) {

		userService.activateUser(active, id);
		return "redirect:/admin/role";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userPage(ModelMap model) {
		return "user";
	}

}
