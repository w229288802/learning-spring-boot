package com.example.demo;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class Chapter18AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter18AdminApplication.class, args);
	}
}
