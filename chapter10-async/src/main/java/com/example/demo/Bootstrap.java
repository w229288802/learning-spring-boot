package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
@EnableAsync
public class Bootstrap {

	private static final int ASYNC_MAX_POOL_SIZE = 2;
	private static final int ASYNC_MAX_QUEUE_CAPACITY = 2;

	@Bean
	public Executor myAsync() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setMaxPoolSize(ASYNC_MAX_POOL_SIZE);
		executor.setQueueCapacity(ASYNC_MAX_QUEUE_CAPACITY);
		// rejection-policy：当pool已经达到max size的时候，如何处理新任务
		// CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
		executor.setRejectedExecutionHandler(new RejectedExecutionHandler(){
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				System.err.println("当前队列已满");
			}
		});
		executor.initialize();
		return executor;
	}
	public static void main(String[] args) {
		SpringApplication.run(Bootstrap.class, args);
	}
}
