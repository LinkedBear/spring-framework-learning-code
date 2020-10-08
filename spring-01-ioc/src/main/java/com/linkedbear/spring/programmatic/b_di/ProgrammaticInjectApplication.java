package com.linkedbear.spring.programmatic.b_di;

import com.linkedbear.spring.programmatic.a_quickstart.bean.Person;
import com.linkedbear.spring.programmatic.b_di.bean.Cat;
import com.linkedbear.spring.programmatic.b_di.bean.Dog;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProgrammaticInjectApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        
        BeanDefinition personDefinition = BeanDefinitionBuilder.rootBeanDefinition(Person.class)
                .addPropertyValue("name", "老王").getBeanDefinition();
        ctx.registerBeanDefinition("laowang", personDefinition);
        
        BeanDefinition catDefinition = BeanDefinitionBuilder.rootBeanDefinition(Cat.class)
                .addPropertyValue("name", "咪咪").addPropertyReference("person", "laowang")//.setLazyInit(true)
                .getBeanDefinition();
        ctx.registerBeanDefinition("mimi", catDefinition);
        
        BeanDefinition dogDefinition = BeanDefinitionBuilder.rootBeanDefinition(Dog.class)
                .addPropertyValue("name", "汪汪").addPropertyReference("person", "laowang")
                // .setScope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
                .setLazyInit(true)
                .getBeanDefinition();
        ctx.registerBeanDefinition("wangwang", dogDefinition);
        
        ctx.refresh();
        System.out.println("ApplicationContext refreshed ......");
        
        Cat cat = ctx.getBean(Cat.class);
        System.out.println(cat);
        
        Dog dog = ctx.getBean(Dog.class);
        System.out.println(dog);
    }
}
