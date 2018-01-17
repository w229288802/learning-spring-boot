

package com.example.configuration.selector;

import com.example.configuration.CustomizedConfiguration;
import com.example.demo.annotation.ImportDefinationRegistrarAnnotation;
import com.example.demo.annotation.ImportSelectorAnnotation;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.MultiValueMap;

public class CustomizedImportDefinationRegistrar implements ImportBeanDefinitionRegistrar {
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        MultiValueMap<String, Object> allAnnotationAttributes = importingClassMetadata.getAllAnnotationAttributes(ImportDefinationRegistrarAnnotation.class.getName());
        String name = ((String) allAnnotationAttributes.get("value").get(0));
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
        rootBeanDefinition.setBeanClassName(name);
        registry.registerBeanDefinition(name,rootBeanDefinition);
    }
}
