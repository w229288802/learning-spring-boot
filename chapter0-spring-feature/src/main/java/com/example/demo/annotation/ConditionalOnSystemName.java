package com.example.demo.annotation;

import com.example.configuration.selector.SystemCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(SystemCondition.class)
public @interface ConditionalOnSystemName {
    String value();
}
