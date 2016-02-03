package mum.cs544.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mum.cs544.model.Admin;
import mum.cs544.model.Role;
import mum.cs544.model.School;
import mum.cs544.service.QueuedEmailService;
import mum.cs544.service.RoleService;
import mum.cs544.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;

	@Autowired
	QueuedEmailService emailService;

	@RequestMapping(value = "/schedular", method = RequestMethod.GET)
	public String schedularPage(Model model) {
		model.addAttribute("emails", emailService.getAll());
		return "schedular";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userPage(ModelMap model) {
		model.addAttribute("schoolUsers", userService.findAllSchoolUsers());
		model.addAttribute("school", new School());
		model.addAttribute("adminUsers", userService.findAllAdminUsers());
		model.addAttribute("admin", new Admin());
		return "user";
	}

	@RequestMapping(value = "/user/school", method = RequestMethod.POST)
	public String addSchool(School schoolUser) {
		System.out.println(schoolUser.getClass());
		userService.addUser(schoolUser);
		return "redirect:/admin/user";
	}

	@RequestMapping(value = "/user/admin", method = RequestMethod.POST)
	public String addAdmin(Admin adminUser) {
		System.out.println(adminUser.getClass());
		userService.addUser(adminUser);
		return "redirect:/admin/user";
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

	@RequestMapping(value = "/admin/activate", method = RequestMethod.POST)
	public String activateAdmin(@RequestParam("id") long id, @RequestParam("active") boolean active) {

		userService.activateUser(active, id);
		return "redirect:/admin/role";
	}

}
