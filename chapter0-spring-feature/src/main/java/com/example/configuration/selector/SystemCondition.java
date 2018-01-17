

package com.example.configuration.selector;

import com.example.demo.annotation.ConditionalOnSystemName;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

public class SystemCondition implements Condition {
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String property = context.getEnvironment().getProperty("os.name");
        MultiValueMap<String, Object> value = metadata.getAllAnnotationAttributes(ConditionalOnSystemName.class.getName());
        return property.toLowerCase().contains((CharSequence) value.get("value").get(0));
    }
}
