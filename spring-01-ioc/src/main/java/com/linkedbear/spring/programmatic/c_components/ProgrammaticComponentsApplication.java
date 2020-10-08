package com.linkedbear.spring.programmatic.c_components;

import com.linkedbear.spring.programmatic.b_di.bean.Animal;
import com.linkedbear.spring.programmatic.b_di.bean.Cat;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.io.ClassPathResource;

import java.beans.Introspector;
import java.util.Set;

public class ProgrammaticComponentsApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    
        /*
        BeanDefinition personDefinition = BeanDefinitionBuilder.rootBeanDefinition(Person.class)
                .addPropertyValue("name", "老王").getBeanDefinition();
        ctx.registerBeanDefinition("laowang", personDefinition);
         */
    
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(ctx);
        reader.loadBeanDefinitions(new ClassPathResource("programmatic/programmatic-components.xml"));
    
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(ctx);
        scanner.addIncludeFilter((metadataReader, metadataReaderFactory) -> {
            return metadataReader.getClassMetadata().getSuperClassName().equals(Animal.class.getName());
        });
        
        // int count = scanner.scan("com.linkedbear.spring.programmatic.b_di.bean");
        Set<BeanDefinition> animalDefinitions = scanner
                .findCandidateComponents("com.linkedbear.spring.programmatic.b_di.bean");
        animalDefinitions.forEach(definition -> {
            MutablePropertyValues propertyValues = definition.getPropertyValues();
            String beanClassName = definition.getBeanClassName();
            propertyValues.addPropertyValue("name", beanClassName);
            propertyValues.addPropertyValue("person", new RuntimeBeanReference("laowang"));
            ctx.registerBeanDefinition(Introspector.decapitalize(beanClassName.substring(beanClassName.lastIndexOf("."))), definition);
        });
        
        ctx.refresh();
    
        Cat cat = ctx.getBean(Cat.class);
        System.out.println(cat);
    }
}
