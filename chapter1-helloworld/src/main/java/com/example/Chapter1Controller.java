package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot快速入门
 */
@RestController
public class Chapter1Controller {
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
}