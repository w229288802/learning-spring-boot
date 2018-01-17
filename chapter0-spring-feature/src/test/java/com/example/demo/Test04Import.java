package com.example.demo;

import com.example.configuration.CustomizedConfiguration;
import com.example.configuration.ImportConfiguration;
import com.example.domain.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ImportConfiguration.class)
public class Test04Import {

	@Autowired
	private Department department;

	@Test
	public void contextLoads() {
		System.out.println(department.getUserList().toString());
	}

}
