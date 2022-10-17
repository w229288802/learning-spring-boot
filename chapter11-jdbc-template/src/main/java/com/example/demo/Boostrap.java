package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

@SpringBootApplication
public class Boostrap {

	@Autowired
	JdbcTemplate jdbcTemplate;
	public static class Test{
		private int c1;
		private String c2;
		private Date c3;
		private Date c4;

		public int getC1() {
			return c1;
		}

		public void setC1(int c1) {
			this.c1 = c1;
		}

		public String getC2() {
			return c2;
		}

		public void setC2(String c2) {
			this.c2 = c2;
		}

		public Date getC3() {
			return c3;
		}

		public void setC3(Date c3) {
			this.c3 = c3;
		}

		public Date getC4() {
			return c4;
		}

		public void setC4(Date c4) {
			this.c4 = c4;
		}

	}
	@PostConstruct
	public void init() throws ExecutionException, InterruptedException {
		List<Test> tests = jdbcTemplate.query("select * from part_tab", new BeanPropertyRowMapper(Test.class));
		System.out.println(tests.get(0).getC4().getTime());
		ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors() *2 );
		ForkJoinTask<Long> submit = forkJoinPool.submit(new MyTask(1, 100000000));
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.err.println("====" + submit.getRawResult());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
			}
		}).start();
		System.out.println(submit.get());
	}


	public class MyTask extends RecursiveTask<Long>{

		private long start;
		private long end;

		public MyTask(long start, long end){
			this.start = start;
			this.end = end;
		}
		@Override
		protected Long compute() {
			if (end - start <= 100) {
				for (long i = start; i <= end; i++) {
					jdbcTemplate.execute(String.format("insert into test values(null, 'name%s','company%s','role%s','email%s','department%s')",i,i,i,i,i));
				}
				System.out.println(String.format("第%s条到第%s条完成", start, end));
				return end - start + 1;
			} else {
				long middle = (end + start) / 2;
				MyTask myTask = new MyTask(start, middle);
				MyTask myTask1 = new MyTask(middle + 1, end);
				myTask1.fork();
				myTask.fork();
				return myTask.join() + myTask1.join();
			}
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(Boostrap.class, args);
	}

}
