package com.sns.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextRegionProviderAutoConfiguration;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@SpringBootApplication (exclude = {ContextStackAutoConfiguration.class, ContextRegionProviderAutoConfiguration.class})
public class SpringbootEmailNotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEmailNotificationApplication.class, args);
	}
	 @Bean
	    public Docket stockApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	        		.apiInfo(getApiInfo())
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.sns.email"))
	                .paths(PathSelectors.any())
	                .build();
	    }
		
		private ApiInfo getApiInfo() {
	        Contact contact = new Contact("SnsEmail.com", "https://docs.aws.amazon.com/sns/latest/dg/welcome.html", "contact.kalpana.ithagoni@wavelabs.ai");
	        return new ApiInfoBuilder()
	                .title("SNS Email Notification Service")
	                .description("Sending Emails through AWS SNS, To subscribe an email address to an Amazon SNS topic using the AWS Management Console")
	                .version("1.0.0")
	                .license("Apache 2.0")
	                .contact(contact)
	                .build();
	    }
}
