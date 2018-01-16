package com.example.demo;

import com.example.demo.scheduling.AsyncService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Bootstrap.class)
public class Chapter10AsyncApplicationTests {

	@Autowired
	private AsyncService schedulingService;

	@Test
	public void contextLoads() throws Exception {
		while (true){
			schedulingService.doTaskOne();
			schedulingService.doTaskTwo();
			schedulingService.doTaskThree();
			Thread.sleep(500);
		}

	}

}
