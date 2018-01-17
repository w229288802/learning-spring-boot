package com.example.demo;

import com.example.configuration.ConditionalConfiguration;
import com.example.domain.Windows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConditionalConfiguration.class)
public class Test03ConditionalAnnotation {

	@Autowired
	private Windows windows;

	@Test
	public void contextLoads() {


	}

}
