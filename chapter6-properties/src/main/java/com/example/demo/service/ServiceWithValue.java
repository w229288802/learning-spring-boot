

package com.example.demo.service;



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@Service
@Slf4j
public class ServiceWithValue {

    @Value("${app.name}")
    private String appName;

    @PostConstruct
    public void init(){
        log.info("app name is '{}'", appName);
    }
}
