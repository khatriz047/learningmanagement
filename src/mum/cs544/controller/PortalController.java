package mum.cs544.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.cs544.model.Question;
import mum.cs544.service.PortalService;

@Controller
public class PortalController {

	@Autowired
	private PortalService portalService;

	@RequestMapping(value = "/portal/question", method = RequestMethod.GET)
	public String postQuestion(Model model) {
		model.addAttribute("list", portalService.getAllQuestion());
		model.addAttribute("question", new Question());
		return "portal";

	}

	@RequestMapping(value = "/portal/question", method = RequestMethod.POST)
	public String postQuestion(Question question) {
		question.setPostDate(new Date());
		portalService.postQuestion(question);
		return "redirect:/portal/question";

	}

}
