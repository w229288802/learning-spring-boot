package com.example.demo;

import com.example.demo.service.properties.CommonProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Properties;

@SpringBootApplication
@EnableConfigurationProperties(CommonProperties.class)
@PropertySources(
		@PropertySource("classpath:/${spring.profiles.active}/common.properties")
)
public class Application {

	public static void main(String[] args) throws IOException {
		//--spring.profiles.active=prod
		SpringApplication springApplication = new SpringApplication(Application.class);
		springApplication.setAddCommandLineProperties(false);
		springApplication.run(args);
		//SpringApplication.run(Application.class, args);
		//Properties properties = PropertiesLoaderUtils.loadAllProperties("dev/common.properties");
		//log.info(properties.toString());
	}
}
