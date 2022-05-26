package com.example.mail.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class SendMail {

    @Autowired
    JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Value("${mail.to}")
    private String to;

    public void sendEmail() throws MessagingException {

        // simple mail plain text
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject("This is a plain text email");
        message.setText("Hello guys! This is a plain text email.");

        mailSender.send(message);

        //--html mail===//
       /* MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        helper.setSubject("This is an HTML email");
        helper.setFrom(from);
        helper.setTo(to);

        boolean html = true;
        helper.setText("<b>Hey guys</b>,<br><i>Welcome to my new home</i>", html);
        mailSender.send(message);*/

        //----mail with attachments----
        /*MimeMessage mimeMessage1 = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage1, true);

        mimeMessageHelper.setSubject("Here's your e-book");
        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setTo(to);

        mimeMessageHelper.setText("<b>Dear friend</b>,<br><i>Please find the book attached.</i>", true);

        FileSystemResource file = new FileSystemResource(new File("C:\\Users\\rekhas\\Downloads\\mail\\src\\main\\resources\\rekha_I2_Test_Jan_2022_1643436195379 (1).pdf"));
        mimeMessageHelper.addAttachment("FreelanceSuccess.pdf", file);

        mailSender.send(message);*/
        System.out.println("mail sent successfully");

    }


}
