package mum.cs544.schedular;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;

public class EmailSchedular {

	@Scheduled(cron = "0/7 * * * * *")
	public void sendQueuedEmails() {
		Date date = Calendar.getInstance().getTime();
		DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT);
		String currenttime = timeFormatter.format(date);
		System.out.println(currenttime + " : Running job " + this.getClass().getName());
	}

}
