package com.example.demo.controller;

import com.example.demo.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 *  Spring Boot中使用Swagger2构建强大的RESTful API文档
 */
@RestController
@SuppressWarnings("all")
@RequestMapping(value="/user")     // 通过这里配置与Swagger
public class Chapter5Controller {
    //@ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value={"/list"}, method= RequestMethod.GET)
    public List<User> getUserList() {
        List<User> r = new ArrayList<User>();
        return r;
    }
}