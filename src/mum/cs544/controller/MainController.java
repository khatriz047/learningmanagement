package mum.cs544.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.cs544.model.User;
import mum.cs544.service.UserService;

@Controller
@SessionAttributes("username")
public class MainController {

	@Autowired
	UserService userService;

	@RequestMapping("/")
	public String redirectRoot() {
		return "login";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String userProfilePage(Model model, HttpSession session) {
		model.addAttribute("user", userService.findByUsername((String) session.getAttribute("username")));
		return "profile";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String updateUserProfile(@Valid User user, BindingResult results, RedirectAttributes redirectAttrs) {
		if (!results.hasErrors()) {
			userService.updateUserProfile(user);
			return "redirect:/profile";
		} else {
			redirectAttrs.addFlashAttribute("error","error");
			return "profile";
		}

	}

	/*
	 * @RequestMapping(value = "/hello/", method = RequestMethod.GET) public
	 * ResponseEntity<List<User>> listAllUsers() {
	 * 
	 * List<User> users = userService.findByUsername(username)
	 * 
	 * return new ResponseEntity<List<User>>(users, HttpStatus.OK); }
	 */

	@RequestMapping(value = "/db", method = RequestMethod.GET)
	public String dbaPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "dba";
	}

	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}

	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

}