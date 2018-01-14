package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot快速入门
 */
@RestController
@SuppressWarnings("all")
public class Chapter2Controller {
    @RequestMapping("/test")
    public String index() {
        return "hello";
    }
}