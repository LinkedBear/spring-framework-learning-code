package com.linkedbear.spring.postprocessor.e_instantiation;

import com.linkedbear.spring.postprocessor.e_instantiation.bean.Ball;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstantiationAwareApplication {
    
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
                "postprocessor/processor-instantiation.xml");
        Ball ball = (Ball) ctx.getBean("ball");
        System.out.println(ball);
        
        Ball ball2 = (Ball) ctx.getBean("ball2");
        System.out.println(ball2);
    }
}
