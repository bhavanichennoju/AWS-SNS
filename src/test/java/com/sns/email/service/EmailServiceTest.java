package com.sns.email.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.amazonaws.services.sns.model.SubscribeResult;
import com.sns.email.config.AwsProperties;
import com.sns.email.model.EmailData;

public class EmailServiceTest {
	@Mock
    private AmazonSNSClient snsClient;
    @Mock
    private SubscribeResult subscribeResult;
    @Mock
    private PublishResult publishResult;

   @Mock
    private AwsProperties awsproperties;

   @InjectMocks
    private EmailService emailService;

   @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
   
   @Test
   public void addSubscriptionTest() throws Exception {
       String email = "kalpanaithagoni@gmail.com";
       SubscribeRequest request = new SubscribeRequest(awsproperties.getTopicArn(), "email", email);
       when(snsClient.subscribe(request)).thenReturn(subscribeResult);
       assertEquals(emailService.addSubscription(email),
               "Subscription request is pending. To confirm the subscription, check your email : " + email);
   }
   @Test
   public void MessageToTopic() throws Exception {
       EmailData mail = new EmailData();
       mail.setAccount_Name("Citi");
       mail.setEvent_End_Date("EventRegion");
       mail.setEvent_Start_Date("16th August 2021");
       mail.setEvent_End_Date("16th August 2022");
       mail.setEvent_TimeZone("asia/pasific");
       mail.setEvent_Type("AGM");
       PublishRequest publishRequest = new PublishRequest(awsproperties.getTopicArn(), mail.toString(),
               "subject : \"Event updated for Client starting on 16 December 2023 12:00 AM !!\"");
       when(snsClient.publish(Mockito.any())).thenReturn(publishResult);
       assertEquals(emailService.publishMessageToTopic(mail),"Event updated successfully !!" );
   }
}
