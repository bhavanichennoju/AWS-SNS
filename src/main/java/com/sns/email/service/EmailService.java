package com.sns.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.sns.email.config.AwsProperties;
import com.sns.email.model.EmailData;
@Service
public class EmailService {
	@Autowired
    private AmazonSNSClient snsClient;
	@Autowired
    private AwsProperties awsProperties;
	public String addSubscription(String email) {
		SubscribeRequest request = new SubscribeRequest(awsProperties.getTopicArn(), "email", email);
		snsClient.subscribe(request);
		return "Subscription request is pending. To confirm the subscription, check your email : " + email;
	}
	private String buildEmailBody(EmailData emailData){
		StringBuilder sb=new StringBuilder();
		  sb.append("Account name  :  " + emailData.getAccount_Name() + "\n" + "Event Name  :  "
	                + emailData.getEvent_Name() + "\n" + "Event Start date  :  " + emailData.getEvent_Start_Date() + "\n"
	                + "Event end date  :  " + emailData.getEvent_End_Date() + "\n" + "Event type  :  "
	                + emailData.getEvent_Type() + "\n" + "Event TimeZone  :  " + emailData.getEvent_TimeZone() + "\n");
	        return sb.toString();
	}
	 public String  publishMessageToTopic(EmailData emailData){	
	         PublishRequest publishRequest=new PublishRequest(awsProperties.getTopicArn(),buildEmailBody(emailData),"subject : \"Event updated for Client starting on 16 December 2023 12:00 AM !!\"");
	         snsClient.publish(publishRequest);
	         return "Event updated successfully !!";
	    }
}
