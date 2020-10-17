package com.linkedbear.spring.configuration.e_enablejdbc.components;

import com.linkedbear.spring.configuration.e_enablejdbc.annotation.ConditionalOnClassName;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class OnClassNameConditional implements Condition {
    
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String className = (String) metadata.getAnnotationAttributes(ConditionalOnClassName.class.getName()).get("value");
        try {
            Class.forName(className);
            return true;
        } catch (ClassNotFoundException e) {
        	return false;
        }
    }
}
