package mum.cs544.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mum.cs544.model.Answer;
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

	@RequestMapping(value = "/portal/answer", method = RequestMethod.GET)
	public String answer(Model model) {
		model.addAttribute("list", portalService.getAllQuestion());
		model.addAttribute("question", new Question());
		return "portal";

	}

	@RequestMapping(value = "/portal/answer/{id}", method = RequestMethod.GET)
	public String postAnswer(@PathVariable int id, Model model) {
		model.addAttribute("questionone", portalService.getQuestion(id));
		model.addAttribute("answer", new Answer());
		return "answer";
	}

	@RequestMapping(value = "/portal/answer", method = RequestMethod.POST)
	public String postAnswer(@RequestParam("id") Long id, Answer answer) {
		portalService.postAnswer(answer);

		return "redirect:/portal/answer";
	}

}
