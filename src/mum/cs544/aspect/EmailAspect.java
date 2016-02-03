package mum.cs544.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import mum.cs544.model.Admin;
import mum.cs544.model.Professor;
import mum.cs544.model.QueuedEmail;
import mum.cs544.model.School;
import mum.cs544.model.Student;
import mum.cs544.model.User;
import mum.cs544.service.QueuedEmailService;
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

		QueuedEmail email = new QueuedEmail();
		email.setEmailto(user.getEmail());
		email.setType(user.getClass().getName());
		email.setEmailfrom("to.sujan.maharjan@gmail.com");
		email.setSubject("User created successfully!");
		StringBuffer buffer = new StringBuffer();
		buffer.append("Hello,\n");
		buffer.append("Your account has been created. Please login with the following credential in our website:\n\n");
		buffer.append("username:" + user.getUsername() + "\n");
		buffer.append("password:" + user.getPassword() + "\n\n");
		buffer.append("Thank you!");

		email.setMessage(buffer.toString());
		email.setStatus(EmailUtils.EMAIL_NOT_SENT);

		emailService.addEmail(email);

	}

}
