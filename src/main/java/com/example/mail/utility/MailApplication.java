package com.example.mail.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class MailApplication implements CommandLineRunner {

@Autowired
SendMail sendMail;

	public static void main(String[] args) {
		SpringApplication.run(MailApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {
     sendMail.sendEmail();
	}
}
