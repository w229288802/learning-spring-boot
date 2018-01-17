

package com.example.configuration;

import com.example.configuration.selector.CustomizedImportDefinationRegistrar;
import com.example.demo.annotation.ImportDefinationRegistrarAnnotation;
import com.example.demo.annotation.ImportSelectorAnnotation;
import com.example.domain.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ImportDefinationRegistrarAnnotation("com.example.domain.User")
public class ImportDefinationRegistrarConfiguration {
}
