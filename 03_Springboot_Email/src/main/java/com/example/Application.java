package com.example;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Application {

	@Autowired
	private EmailSenderService emailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
		emailSenderService.sendMailWithAttachment("eshwarnaz786@gmail.com",
				"Hi , please find my resume as an attachment", "Java Developer",
				"" + "C:\\Users\\ESHWARNAZ\\OneDrive\\Desktop\\JAVATASKS\\TASKS\\Task -03 youtube\\resume.txt");

	}

}
