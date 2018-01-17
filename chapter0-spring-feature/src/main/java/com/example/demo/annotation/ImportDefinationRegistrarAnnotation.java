

package com.example.demo.annotation;

import com.example.configuration.selector.CustomizedImportDefinationRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(CustomizedImportDefinationRegistrar.class)
public @interface ImportDefinationRegistrarAnnotation {
    String value();
}
