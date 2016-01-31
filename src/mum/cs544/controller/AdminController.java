package mum.cs544.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mum.cs544.dto.ChangePasswordDTO;
import mum.cs544.model.Role;
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
		return "school";
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

	@RequestMapping(value = "/delete.htm", method = RequestMethod.POST)
	public String deleteRole(@RequestParam("id") Long id) {

		roleService.delete(id);
		return "redirect:/admin/role";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userPage(ModelMap model) {
		return "user";
	}

}
