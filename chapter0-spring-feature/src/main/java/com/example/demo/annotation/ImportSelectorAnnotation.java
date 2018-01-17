package com.example.demo.annotation;

import com.example.configuration.selector.CustomizedImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(CustomizedImportSelector.class)
public @interface ImportSelectorAnnotation {
    boolean value();
}
