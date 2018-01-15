package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Chapter1Controller {
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
}