package mum.cs544.utils;

import java.text.DecimalFormat;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

import mum.cs544.model.QueuedEmail;
import mum.cs544.model.User;

public class EmailUtils {

	public static int EMAIL_NOT_SENT = 0;
	public static int EMAIL_SENT = 1;
	public static int EMAIL_SENT_FAILED = 2;

	public static QueuedEmail setQueuedEmail(StringBuffer message, String subject, User user) throws Exception {

		try {
			QueuedEmail queuedEmail = new QueuedEmail();
			queuedEmail.setSubject(subject);

			queuedEmail.setMessage(message.toString());
			queuedEmail.setEmailfrom("to.sujan.maharjan@gmail.com");
			queuedEmail.setCc("thesujan540@gmail.com");
			queuedEmail.setType("");

			queuedEmail.setEmailto(user.getEmail());
			queuedEmail.setStatus(EMAIL_NOT_SENT);

			System.out.println("Successfully created queued email");

			return queuedEmail;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static Double decimalFormat(Double d) throws Exception {

		DecimalFormat df = new DecimalFormat("##.##");

		return new Double(df.format(d));

	}

	public static boolean sendEmailNotification(List<String> emailRecipients, String subject, StringBuffer body)
			throws Exception {

		try {
			SimpleEmail email = new SimpleEmail();
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(587);
			email.setFrom("thesujan540@gmail.com");
			email.setAuthenticator(new DefaultAuthenticator("thesujan540@gmail.com", "sujanfaith"));
			email.setTLS(true);

			for (String emailRecipient : emailRecipients) {
				email.addTo(emailRecipient);
			}

			email.setSubject(subject);

			email.setMsg("\nPlease save your submission code:" + body.toString()
					+ "\n\nThank you!\n Software Development House Nepal");

			email.send();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

	public static void main(String[] args) {
		try {
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}