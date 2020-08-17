package com.linkedbear.spring.basic_dl.f_lazylookup;

import com.linkedbear.spring.basic_dl.f_lazylookup.bean.Cat;
import com.linkedbear.spring.basic_dl.f_lazylookup.bean.Dog;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ImmediatlyLookupApplication {
    
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("basic_dl/quickstart-lazylookup.xml");
        Cat cat = ctx.getBean(Cat.class);
        System.out.println(cat);
        
//        Dog dog;
//        try {
//            dog = ctx.getBean(Dog.class);
//        } catch (NoSuchBeanDefinitionException e) {
//        	dog = new Dog();
//        }
        
        Dog dog = ctx.containsBean("dog") ? (Dog) ctx.getBean("dog") : new Dog();
        
        System.out.println(dog);
    }
}
