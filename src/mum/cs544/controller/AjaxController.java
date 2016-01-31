package mum.cs544.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import mum.cs544.dto.ChangePasswordDTO;
import mum.cs544.dto.SearchCriteria;
import mum.cs544.model.AjaxResponseBody;
import mum.cs544.model.User;
import mum.cs544.service.UserService;

@RestController
public class AjaxController {

	@Autowired
	private UserService userService;

	@RequestMapping("/hello")
	public ModelAndView helloWorld() {
		return new ModelAndView("hello", "message", "Spring MVC Demo");
	}

	@RequestMapping(value = "/time", method = RequestMethod.GET)
	public @ResponseBody String getTime(@RequestParam String name) {
		String result = "Time for " + name + " is " + new Date().toString();
		return result;
	}

	@RequestMapping(value = "profile/changepassword")
	public String changePassword(ChangePasswordDTO changePasswordDTO) {
		System.out.println(changePasswordDTO.getId());
		System.out.println(changePasswordDTO.getConfirmPassword());

		long id = changePasswordDTO.getId();
		User user = userService.findById(id);

		if (changePasswordDTO.isMatched(user.getPassword())) {
			userService.updateUserPassword(changePasswordDTO.getNewPassword(), id);
			return "Successfully updated";
		}
		System.out.println(user.getContactNumber());
		System.out.println("this is test..");
		return "Failed to update";
	}

	@RequestMapping(value = "profile/getSearchResult")
	public AjaxResponseBody getSearchResultViaAjax(@RequestBody SearchCriteria search) {

		AjaxResponseBody result = new AjaxResponseBody();

		if (isValidSearchCriteria(search)) {
			List<User> users = userService.findByUsernameOrEmail(search.getUsername(), search.getEmail());
			System.out.println(users.size());

			if (users.size() > 0) {
				result.setCode("200");
				result.setMsg("");
				result.setResult(users);
			} else {
				result.setCode("204");
				result.setMsg("No user!");
			}

		} else {
			result.setCode("400");
			result.setMsg("Search criteria is empty!");
		}

		// AjaxResponseBody will be converted into json format and send back to
		// client.
		return result;

	}

	private boolean isValidSearchCriteria(SearchCriteria search) {

		boolean valid = true;

		if (search == null) {
			valid = false;
		}

		if ((StringUtils.isEmpty(search.getUsername())) && (StringUtils.isEmpty(search.getEmail()))) {
			valid = false;
		}

		return valid;
	}

}
