package com.linkedbear.spring.configuration.e_enablejdbc.config;

import com.linkedbear.spring.configuration.e_enablejdbc.components.JdbcConfigSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(JdbcConfigSelector.class)
public @interface EnableJdbc {
    
}
