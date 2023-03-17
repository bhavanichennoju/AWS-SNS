package com.sns.email.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.SubscribeResult;
import com.sns.email.model.EmailData;
import com.sns.email.service.EmailService;
@ExtendWith(MockitoExtension.class)
public class EmailControllerTest {
	@Mock
	private AmazonSNSClient snsClient;
	 @Mock
	 private SubscribeResult subscribeResult;
	 @Mock
	 private PublishResult publishResult;
	 @Mock
	 private EmailService emailService;
	 @InjectMocks
	 private EmailController emailController;
	@Test
	public void addSubscriptionTest() throws Exception {
		    String email="kalpanaithagoni@gmail.com";
	        when(emailService.addSubscription(email)).thenReturn(email);
	        assertEquals(email,emailController.addSubscription(email));
	    }
	
	@Test
	public void publishMessageToTopic() throws Exception{
		EmailData emailData=new EmailData("citi", " RegionTypeChecking","16th Aug 2021","16th Aug 2022","Asia/Calcutta","AGM");
        when(emailService.publishMessageToTopic(emailData)).thenReturn(" ");
	    assertEquals(" ",emailController.publishMessageToTopic(emailData));
	}
	
	
}
