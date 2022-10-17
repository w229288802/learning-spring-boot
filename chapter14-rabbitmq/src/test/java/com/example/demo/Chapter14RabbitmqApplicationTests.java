package com.example.demo;

import com.example.demo.config.MqConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;

import static com.example.demo.Chapter14RabbitmqApplicationTests.TASK_QUEUE;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter14RabbitmqApplicationTests {
	public static final String TASK_QUEUE = "task_queue";
	public static final String TASK_QUEUE1 = "task_queue1";
	public static final String TASK_QUEUE2 = "task_queue2";
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private AmqpTemplate amqpTemplate;

	public static CountDownLatch countDownLatch;

	@Test
	public void contextLoads() throws InterruptedException {
		countDownLatch = new CountDownLatch(2);
		CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
		rabbitTemplate.convertAndSend("direct", TASK_QUEUE1, "test", correlationData);
		rabbitTemplate.convertAndSend("direct", TASK_QUEUE, "test", correlationData);
		countDownLatch.await();
		System.out.println("执行完成");
		Thread.sleep(1000);
	}

	@Test
	public void contextLoads2() throws InterruptedException {
		countDownLatch = new CountDownLatch(10);
		CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
		for (int i = 0; i < 10; i++) {
			rabbitTemplate.convertAndSend("direct", TASK_QUEUE2, "test", correlationData);
		}
		countDownLatch.await();
		System.out.println("执行完成");
		Thread.sleep(1000);
	}


	@Test
	public void test() throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			rabbitTemplate.convertAndSend("spring.work.queue", "1");
		}
		Thread.sleep(2000);
	}

}
