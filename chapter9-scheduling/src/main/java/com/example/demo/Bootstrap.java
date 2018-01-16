package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class Bootstrap {

	@Scheduled(cron = "*/1 * * * * *")
	public void task1(){
		System.out.println("每一秒执行一次");
	}

	@Scheduled(fixedRate = 2000)
	public void task2(){
		System.out.println("每两秒执行一次");
	}

	public static void main(String[] args) {
		SpringApplication.run(Bootstrap.class, args);
	}
}
