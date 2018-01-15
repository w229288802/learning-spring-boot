package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Chapter7Controller {
    @RequestMapping("/index")
    public String index() {
        throw new RuntimeException();
    }

}
