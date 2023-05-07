package com.UniProject.Training.Advisor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class TrainingAdvisorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingAdvisorApplication.class, args);
	}

}
