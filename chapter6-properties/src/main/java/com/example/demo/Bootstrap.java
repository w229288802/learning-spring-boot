package com.example.demo;

import com.example.demo.service.properties.CommonProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import java.io.IOException;

@SpringBootApplication
@EnableConfigurationProperties(CommonProperties.class)
@PropertySources(
		@PropertySource("classpath:/${spring.profiles.active}/common.properties")
)
public class Bootstrap {

	public static void main(String[] args) throws IOException {
		//--spring.profiles.active=prod
		SpringApplication springApplication = new SpringApplication(Bootstrap.class);
		springApplication.setAddCommandLineProperties(false);
		springApplication.run(args);
		//SpringApplication.run(Bootstrap.class, args);
		//Properties properties = PropertiesLoaderUtils.loadAllProperties("dev/common.properties");
		//log.info(properties.toString());
	}
}
