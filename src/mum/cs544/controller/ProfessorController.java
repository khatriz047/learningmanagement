package mum.cs544.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import mum.cs544.model.Answer;
import mum.cs544.model.Course;
import mum.cs544.model.Question;
import mum.cs544.model.Resource;
import mum.cs544.model.Student;
import mum.cs544.model.User;
import mum.cs544.service.AnswerService;
import mum.cs544.service.CourseService;
import mum.cs544.service.FacultyService;
import mum.cs544.service.QuestionService;
import mum.cs544.service.ResourceService;
import mum.cs544.service.UserService;
import mum.cs544.utils.FileMeta;

@Controller
@RequestMapping(value = "/professor")
@SessionAttributes("facultiesmap")
public class ProfessorController {

	@Autowired
	private FacultyService facultyService;

	@Autowired
	private UserService userService;

	@Autowired
	private CourseService courseService;

	@Autowired
	private ResourceService resourceService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private AnswerService answerService;

	@Autowired
	ServletContext context;

	@RequestMapping(value = "/discussion", method = RequestMethod.GET)
	public String questionPage(ModelMap model) {
		model.addAttribute("questions", questionService.getAllQuestion());
		model.addAttribute("question", new Question());
		model.addAttribute("facultiesmap", facultyService.getFacultiesMap());
		return "discussion";
	}
	
	@RequestMapping(value = "/discussion/course/{id}", method = RequestMethod.GET)
	public String questionPageWrtCourse(@PathVariable long id,ModelMap model) {
		model.addAttribute("questions", questionService.findByCourse(id));
		model.addAttribute("question", new Question());
		model.addAttribute("facultiesmap", facultyService.getFacultiesMap());
		return "discussion";
	}

	@RequestMapping(value = "/discussion/question", method = RequestMethod.POST)
	public String addQuestion(Question question, HttpSession session) {

		User user = userService.findByUsername((String) session.getAttribute("username"));
		question.setUser(user);
		question.setPostDate(new Date());
		questionService.addQuestion(question);

		return "redirect:/professor/discussion";
	}

	@RequestMapping(value = "/discussion/answer/{id}", method = RequestMethod.GET)
	public String getAnswerPage(@PathVariable long id, Model model) {
		Answer answer = new Answer();
		model.addAttribute("answer", answer);
		return "answer";
	}

	@RequestMapping(value = "/discussion/answer/{id}", method = RequestMethod.POST)
	public String addAnswer(@PathVariable long id, Answer answer, HttpSession session) {
		Question question = questionService.getQuestionById(id);
		System.out.println(question.getId());
		User user = userService.findByUsername((String) session.getAttribute("username"));
		answer.setUser(user);
		answer.setAnswerDate(new Date());
		answer.setQuestion(question);
		
		
		question.addAnswer(answer);
		
		answerService.addAnswer(answer);
		return "redirect:/professor/discussion";
	}

	@RequestMapping(value = "/discussion/question/delete", method = RequestMethod.POST)
	public String deleteQuestion(@RequestParam("id") long id) {
		questionService.delete(id);
		return "redirect:/professor/discussion";
	}

	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public String messagePage(ModelMap model) {
		return "message";
	}

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String professorPage(ModelMap model) {
		model.addAttribute("studentUsers", userService.findAllStudentUsers());
		model.addAttribute("student", new Student());
		model.addAttribute("facultiesmap", facultyService.getFacultiesMap());
		return "student";
	}

	@RequestMapping(value = "/student/student", method = RequestMethod.POST)
	public String addStudent(Student studentUser) {
		if (studentUser.getCoursesids() != null)
			for (Long id : studentUser.getCoursesids()) {
				studentUser.addCourse(courseService.findById(id));
			}
		userService.addUser(studentUser);
		return "redirect:/professor/student";
	}

	@RequestMapping(value = "/student/activate", method = RequestMethod.POST)
	public String activateProfessor(@RequestParam("id") long id, @RequestParam("active") boolean active) {

		userService.activateUser(active, id);
		return "redirect:/professor/student";
	}

	@RequestMapping(value = "/faculty/{id}", method = RequestMethod.GET)
	public String getFaculty(@PathVariable long id, Model model) {
		return "professoradmin";
	}

	@RequestMapping(value = "/course/jsoncourselist/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Course> getCourseList(@PathVariable long id) {
		return courseService.getCourses(id);
	}
	
	@RequestMapping(value = "/question/jsonquestionwrtcourse/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Question> getQuestionsWrtCourse(@PathVariable long id) {
		return questionService.findByCourse(id);
	}

	@RequestMapping(value = "/resource", method = RequestMethod.GET)
	public String resourcePage(ModelMap model) {
		model.addAttribute("resources", resourceService.getResources());
		model.addAttribute("resource", new Resource());
		model.addAttribute("facultiesmap", facultyService.getFacultiesMap());
		return "resourceprofessor";
	}

	@RequestMapping(value = "/resource", method = RequestMethod.POST)
	public String addFaculty(Resource resource, HttpSession session) {

		resource.setPostedDate(new Date());
		resource.setUser(userService.findByUsername((String) session.getAttribute("username")));

		resourceService.addResource(resource);

		return "redirect:/professor/resource";
	}

	@RequestMapping(value = "/resource/delete", method = RequestMethod.POST)
	public String deleteFaculty(@RequestParam("id") long id) {

		resourceService.delete(id);
		return "redirect:/professor/resource";
	}

	@RequestMapping(value = "profile/upload", method = RequestMethod.POST)
	public @ResponseBody LinkedList<FileMeta> uploading(MultipartHttpServletRequest request,
			HttpServletResponse response) {

		LinkedList<FileMeta> files = new LinkedList<FileMeta>();
		FileMeta fileMeta = null;

		String FILE_URL = context.getRealPath("") + "resources/";

		/*
		 * String officialEmail ="SDS";// request.getParameter("officialEmail");
		 * if (StringUtils.isNotEmpty(officialEmail) &&
		 * officialEmail.contains("@")) { officialEmail =
		 * officialEmail.substring(0, officialEmail.indexOf('@')); }
		 */

		// 1. build an iterator
		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf = null;

		// 2. get each file
		while (itr.hasNext()) {

			// 2.1 get next MultipartFile
			mpf = request.getFile(itr.next());
			System.out.println(mpf.getOriginalFilename() + " uploaded! " + files.size());

			// 2.2 if files > 10 remove the first from the list
			if (files.size() >= 10)
				files.pop();

			// 2.3 create new fileMeta
			fileMeta = new FileMeta();
			fileMeta.setFileName(mpf.getOriginalFilename());
			fileMeta.setFileSize(mpf.getSize() / 1024 + " Kb");
			fileMeta.setFileType(mpf.getContentType());
			fileMeta.setFileURL(FILE_URL + mpf.getOriginalFilename());

			try {
				fileMeta.setBytes(mpf.getBytes());

				File originalFile = new File(FILE_URL + mpf.getOriginalFilename());
				System.out.println("FILE_URL : " + FILE_URL);
				/*
				 * File renamedFile = new File(FILE_URL + officialEmail + "_" +
				 * mpf.getOriginalFilename()); if
				 * (originalFile.renameTo(renamedFile)) {
				 * System.out.println("Renamed"); } else { System.out.println(
				 * "Renaming failed"); }
				 */

				// copy file to local disk (make sure the path
				// "e.g. D:/temp/files" exists)
				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(originalFile));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 2.4 add to files
			files.add(fileMeta);

		}

		// result will be like this
		// [{"fileName":"app_engine-85x77.png","fileSize":"8
		// Kb","fileType":"image/png"},...]
		return files;

	}

}
