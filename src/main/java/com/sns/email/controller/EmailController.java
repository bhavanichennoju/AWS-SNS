package com.sns.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sns.email.model.EmailData;
import com.sns.email.service.EmailService;


@RestController
public class EmailController {
	
	@Autowired
	private EmailService emailService;

	@GetMapping("/addSubscription/{email}")
	public String addSubscription(@PathVariable String email) {
		return emailService.addSubscription(email);
	}
	@PostMapping("/sendNotification")
    public String  publishMessageToTopic(@RequestBody EmailData emailData){	
         return emailService.publishMessageToTopic(emailData);
    }
	
}
