package com.wishalpha.priyanshu.TaskManagementSystem;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskManagementSystemApplication implements CommandLineRunner {

	@Value("${spring.app.appURL}")
	private String appUrl;

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(TaskManagementSystemApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementSystemApplication.class, args);
//		System.out.println("API Docs http://localhost:8080/v3/api-docs");
//		System.out.println("Swagger UI http://localhost:8080/swagger-ui-taskmanagement.html");
	}

	@Override
	public void run(final String... args){
		log.info("Application running at {}",appUrl);
	}

}
