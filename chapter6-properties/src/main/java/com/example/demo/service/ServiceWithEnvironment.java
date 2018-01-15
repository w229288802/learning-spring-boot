


package com.example.demo.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@Service
@Slf4j
public class ServiceWithEnvironment {
    @Autowired
    private Environment environment;

    @PostConstruct
    public void init(){
        log.info("app name is '{}'", environment.getProperty("app.name"));
    }
}
