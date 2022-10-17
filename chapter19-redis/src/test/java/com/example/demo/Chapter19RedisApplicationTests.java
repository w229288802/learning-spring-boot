package com.example.demo;

import com.example.demo.app.RedisLock;
import com.example.demo.app.RedisLockUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.RedissonLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter19RedisApplicationTests {
	public static final String TASK_QUEUE = "task_queue";
	public static final String TASK_QUEUE1 = "task_queue1";
	public static final String TASK_QUEUE2 = "task_queue2";
	@Autowired
	private RedisLockUtils redisLockUtils;

	public static CountDownLatch countDownLatch;

	@Autowired
	private RedissonClient redissonClient;

	@Test
	public void contextLoads() throws InterruptedException {
		RLock lock1 = redissonClient.getLock("");
		lock1.lock();
		RedisLock test = redisLockUtils.getLock("test");
		test.lock();
		test.unlock();
		RLock lock = redissonClient.getLock("");
		lock.lock();
	}



}
