package com.example.swagger2;

import io.swagger.models.Swagger;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * Created by haha on 2018/1/14.
 */
@Configuration
@ConditionalOnClass(Swagger.class)
@Import(Swagger2Configuration.class)
public @interface Swagger2AutoConfiguration {

}
