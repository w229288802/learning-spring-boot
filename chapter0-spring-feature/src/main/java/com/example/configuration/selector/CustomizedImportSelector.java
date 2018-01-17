

package com.example.configuration.selector;

import com.example.configuration.CustomizedConfiguration;
import com.example.demo.annotation.ImportSelectorAnnotation;
import com.example.domain.Windows;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.MultiValueMap;

public class CustomizedImportSelector implements ImportSelector {
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        MultiValueMap<String, Object> allAnnotationAttributes = importingClassMetadata.getAllAnnotationAttributes(ImportSelectorAnnotation.class.getName());
        Boolean value = (Boolean) allAnnotationAttributes.get("value").get(0);
        if(value){
            return new String[]{CustomizedConfiguration.class.getName()};
        }
        return new String[0];
    }
}
