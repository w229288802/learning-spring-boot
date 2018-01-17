package com.example.demo;

import com.example.configuration.CustomizedConfiguration;
import com.example.domain.Department;
import com.example.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CustomizedConfiguration.class)
public class Test01Configuration {

	@Autowired
	private Department department;

	@Test
	public void contextLoads() {
		System.out.println(department.getUserList().toString());
	}

}
