/**
 * 
 */
package com.wipro.online.gym.management.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author Sudhakar Maurya
 */
@Service
public class EmailSender {
	@Autowired 
	private JavaMailSender javaMailSender;

    @Value
    ("${spring.mail.username}") private String sender;
	
	 public String sendSimpleMail(String subject,String recipient,String msgBody) {
		 try {

	            SimpleMailMessage mailMessage= new SimpleMailMessage();
	            mailMessage.setFrom(sender);
	            mailMessage.setTo(recipient);
	            mailMessage.setText(msgBody.toString());
	            mailMessage.setSubject(subject);
	            javaMailSender.send(mailMessage);
	            return "Mail Sent Successfully...";
	        }

	        catch (Exception e) {
	        	e.printStackTrace();
	            return "Error while Sending Mail";
	        }
	 }	
}
