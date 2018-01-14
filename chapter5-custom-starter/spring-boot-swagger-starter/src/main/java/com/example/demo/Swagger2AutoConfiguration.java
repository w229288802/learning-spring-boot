package com.example.demo;

import io.swagger.models.Swagger;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

/**
 * Created by haha on 2018/1/14.
 */
@Configuration
@ConditionalOnClass({Swagger.class})
public @interface Swagger2AutoConfiguration {

}
