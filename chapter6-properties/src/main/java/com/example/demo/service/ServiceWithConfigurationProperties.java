

package com.example.demo.service;


import com.example.demo.service.properties.CommonProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@Service
@Slf4j
public class ServiceWithConfigurationProperties {

    @Autowired
    private CommonProperties config;

    @PostConstruct
    public void init(){
        log.info("app name is '{}'", config.getName());
    }

}
