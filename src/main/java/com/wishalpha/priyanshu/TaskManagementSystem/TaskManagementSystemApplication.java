package com.wishalpha.priyanshu.TaskManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementSystemApplication.class, args);
		System.out.println("Localhost http://localhost:8080");
		System.out.println("API Docs http://localhost:8080/v3/api-docs");
		System.out.println("Swagger UI http://localhost:8080/swagger-ui-taskmanagement.html");
	}

}
