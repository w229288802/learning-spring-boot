package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void init(){
        jdbcTemplate.execute("CREATE TABLE IF NOT  EXISTS `user` (" +
                "`name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ," +
                "`age`  int(11) NULL DEFAULT NULL)" +
                "ENGINE=InnoDB DEFAULT CHARACTER SET=utf8");
    }

    @Override
    public void create(String name, Integer age) {
        jdbcTemplate.update("insert into user(NAME, AGE) values(?, ?)", name, age);
    }
    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from user where NAME = ?", name);
    }
    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from user", Integer.class);
    }
    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from user");
    }
}