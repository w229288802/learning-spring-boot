package com.example.demo;

import ch.qos.logback.classic.LoggerContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter13MultipleDatasourceApplicationTests {

	@Autowired
	@Qualifier("primaryJdbcTemplate")
	protected JdbcTemplate jdbcTemplate1;

	@Autowired
	@Qualifier("secondaryJdbcTemplate")
	protected JdbcTemplate jdbcTemplate2;

	@Before
	public void setUp() {
		jdbcTemplate1.execute("CREATE TABLE IF NOT  EXISTS `user` (" +
				"`name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ," +
				"`age`  int(11) NULL DEFAULT NULL)" +
				"ENGINE=InnoDB DEFAULT CHARACTER SET=utf8");

		jdbcTemplate2.execute("CREATE TABLE IF NOT  EXISTS `user` (" +
				"`name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ," +
				"`age`  int(11) NULL DEFAULT NULL)" +
				"ENGINE=InnoDB DEFAULT CHARACTER SET=utf8");

		jdbcTemplate1.execute("DELETE FROM user");
		jdbcTemplate2.execute("DELETE FROM user");
		//jdbcTemplate1.execute("CREATE TABLE `user` (`id` int(11) ,`name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,`age`  int(11) NULL DEFAULT NULL)ENGINE=InnoDB DEFAULT CHARACTER SET=utf8");
		//jdbcTemplate2.execute("CREATE TABLE `user` (`id` int(11) ,`name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,`age`  int(11) NULL DEFAULT NULL)ENGINE=InnoDB DEFAULT CHARACTER SET=utf8");
	}

	@Test
	public void contextLoads() throws Exception {

		// 往第一个数据源中插入两条数据
		jdbcTemplate1.update("insert into user(name,age) values(?, ?)",  "aaa", 20);
		jdbcTemplate1.update("insert into user(name,age) values(?, ?)",  "bbb", 30);

		// 往第二个数据源中插入一条数据，若插入的是第一个数据源，则会主键冲突报错
		jdbcTemplate2.update("insert into user(name,age) values(?, ?)",  "aaa", 20);

		// 查一下第一个数据源中是否有两条数据，验证插入是否成功
		Assert.assertEquals("2", jdbcTemplate1.queryForObject("select count(1) from user", String.class));

		// 查一下第一个数据源中是否有两条数据，验证插入是否成功
		Assert.assertEquals("1", jdbcTemplate2.queryForObject("select count(1) from user", String.class));

	}

}
