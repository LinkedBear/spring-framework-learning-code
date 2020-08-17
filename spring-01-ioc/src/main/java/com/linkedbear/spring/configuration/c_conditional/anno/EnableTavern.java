package com.linkedbear.spring.configuration.c_conditional.anno;

import com.linkedbear.spring.configuration.c_conditional.component.Boss;
import com.linkedbear.spring.configuration.c_conditional.config.BartenderConfiguration;
import com.linkedbear.spring.configuration.c_conditional.registrar.WaiterRegistrar;
import com.linkedbear.spring.configuration.c_conditional.selector.BarImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({BartenderConfiguration.class, BarImportSelector.class, WaiterRegistrar.class})
public @interface EnableTavern {
    
}
