
package com.example.demo.annotation;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
@ComponentScan("com.example.domain")
public @interface CombinedAnnotation {
}
