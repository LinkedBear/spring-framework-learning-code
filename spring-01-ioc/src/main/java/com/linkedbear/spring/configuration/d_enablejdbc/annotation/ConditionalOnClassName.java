package com.linkedbear.spring.configuration.d_enablejdbc.annotation;

import com.linkedbear.spring.configuration.d_enablejdbc.components.OnClassNameConditional;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Conditional(OnClassNameConditional.class)
public @interface ConditionalOnClassName {
    
    String value();
}
