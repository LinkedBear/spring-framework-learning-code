package com.linkedbear.spring.event.d_payload;

import com.linkedbear.spring.basic_dl.a_quickstart_byname.bean.Person;
import com.linkedbear.spring.event.d_payload.component.PayloadIntegerApplicationListener;
import com.linkedbear.spring.event.d_payload.component.PayloadObjectApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PayloadEventApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.addApplicationListener(new PayloadObjectApplicationListener());
        ctx.addApplicationListener(new PayloadIntegerApplicationListener());
        ctx.refresh();
        
        ctx.publishEvent("hahaha");
        ctx.publishEvent(123456789);
        ctx.publishEvent(new Person());
    }
}
