package mum.cs544.aspect;

import java.util.Date;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import mum.cs544.model.Admin;
import mum.cs544.model.Answer;
import mum.cs544.model.Course;
import mum.cs544.model.Professor;
import mum.cs544.model.Question;
import mum.cs544.model.QueuedEmail;
import mum.cs544.model.Resource;
import mum.cs544.model.School;
import mum.cs544.model.Student;
import mum.cs544.model.User;
import mum.cs544.service.AnswerServiceImpl;
import mum.cs544.service.QuestionServiceImpl;
import mum.cs544.service.QueuedEmailService;
import mum.cs544.service.ResourceServiceImpl;
import mum.cs544.utils.EmailUtils;

@Aspect
public class EmailAspect {

	@Autowired
	private QueuedEmailService emailService;

	@After("execution(* mum.cs544.service.UserServiceImpl.addUser(..))")
	public void createUserEmailQueue(JoinPoint joinpoint) {

		System.out.println("Running aspect : execution(* mum.cs544.service.UserServiceImpl.addUser(..))");

		Object[] args = joinpoint.getArgs();
		User user = (User) args[0];

		if (user instanceof School) {
			user = (School) user;
		} else if (user instanceof Admin) {
			user = (Admin) user;
		} else if (user instanceof Professor) {
			user = (Professor) user;
		} else if (user instanceof Student) {
			user = (Student) user;
		}

		StringBuffer buffer = new StringBuffer();
		buffer.append("Hello,\n");
		buffer.append("Your account has been created. Please login with the following credential in our website:\n\n");
		buffer.append("username:" + user.getUsername() + "\n");
		buffer.append("password:" + user.getPassword() + "\n\n");
		buffer.append("Thank you!");

		createEmailQueued(user.getEmail(), "User created successfully!", buffer.toString(),
				user.getClass().getSimpleName() + " user created");

	}

	@After("execution(* mum.cs544.service.ResourceServiceImpl.addResource(..))")
	public void createResourceEmailQueue(JoinPoint joinpoint) {

		System.out.println("Running aspect : execution(* mum.cs544.service.ResourceServiceImpl.addResource(..))");

		Object[] args = joinpoint.getArgs();
		Resource resource = (Resource) args[0];

		User user = resource.getUser();

		Course course = resource.getCourse();

		ResourceServiceImpl resourceService = (ResourceServiceImpl) joinpoint.getTarget();

		List<String> emails = resourceService.getEmailIDsFromCourses(course.getId());

		StringBuffer buffer = new StringBuffer();
		buffer.append("Hello,\n");
		buffer.append("Following resource had been upload:\n\n");
		buffer.append("File Name:" + resource.getResourceurl() + "\n");
		buffer.append("Type:" + resource.getResourcetype() + "\n");
		buffer.append("Size:" + resource.getResourcesize() + "\n");
		buffer.append("Uploaded by:" + user.getFullName() + "\n\n");
		buffer.append("Thank you!");

		for (String email : emails) {
			createEmailQueued(email, buffer.toString(), course.getName() + " resource added by " + user.getFullName(),
					"Resource");
		}

	}

	@After("execution(* mum.cs544.service.AnswerServiceImpl.updateAnswerResult(..))")
	public void createAnswerEmailQueue(JoinPoint joinpoint) {

		System.out.println("Running aspect : execution(* mum.cs544.service.AnswerServiceImpl.addQuestion(..))");

		Object[] args = joinpoint.getArgs();
		long answer_id = (long) args[2];

		AnswerServiceImpl answerService = (AnswerServiceImpl) joinpoint.getTarget();

		Answer answer = answerService.getAnswerById(answer_id);
		User user = answer.getUser();
		Course course = answer.getQuestion().getCourse();

		List<String> emails = answerService.getEmailIDsFromCourses(course.getId());

		StringBuffer buffer = new StringBuffer();
		buffer.append("Hello,\n");
		buffer.append("Answer has been posted by +" + user.getFullName() + " for question \""
				+ answer.getQuestion().getQuestionbody() + "\":\n\n");
		buffer.append("\"" + answer.getAnswerbody() + "\"\n");
		buffer.append("Thank you!");

		for (String email : emails) {
			createEmailQueued(email, buffer.toString(), course.getName() + " : answer added by " + user.getFullName(),
					"Answer");
		}

	}

	@After("execution(* mum.cs544.service.QuestionServiceImpl.addQuestion(..))")
	public void createQuestionEmailQueue(JoinPoint joinpoint) {

		System.out.println("Running aspect : execution(* mum.cs544.service.QuestionServiceImpl.addQuestion(..))");

		Object[] args = joinpoint.getArgs();
		Question question = (Question) args[0];

		User user = question.getUser();

		Course course = question.getCourse();

		QuestionServiceImpl questionService = (QuestionServiceImpl) joinpoint.getTarget();

		List<String> emails = questionService.getEmailIDsFromCourses(course.getId());

		StringBuffer buffer = new StringBuffer();
		buffer.append("Hello,\n");
		buffer.append("Question has been posted by +" + user.getFullName() + ":\n\n");
		buffer.append("\"" + question.getQuestionbody() + "\"\n");
		buffer.append("Thank you!");

		for (String email : emails) {
			createEmailQueued(email, buffer.toString(), course.getName() + " : question added by " + user.getFullName(),
					"Question");
		}

	}

	private void createEmailQueued(String emailto, String subject, String message, String type) {
		QueuedEmail email = new QueuedEmail();
		email.setEmailto(emailto);
		email.setType(type);
		email.setEmailfrom("to.sujan.maharjan@gmail.com");
		email.setSubject(subject);

		email.setMessage(message);
		email.setStatus(EmailUtils.EMAIL_NOT_SENT);
		email.setCreateddate(new Date());

		emailService.addEmail(email);
	}

}
