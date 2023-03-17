package com.sns.email.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
@Configuration
public class AWSNSConfig {
	@Autowired
    private AwsProperties awsProperties;
	    @Value("${aws.sns.accessKey}")
	    private String awsAccessKey;
	    @Value("${aws.sns.secretKey}")
	    private String awsSecretKey;

    @Primary
    @Bean
    public AmazonSNSClient getSnsClient() {
        return (AmazonSNSClient) AmazonSNSClientBuilder.standard().withRegion(awsProperties.getRegion())
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey,
                		awsSecretKey)))
                .build();
    }
}
