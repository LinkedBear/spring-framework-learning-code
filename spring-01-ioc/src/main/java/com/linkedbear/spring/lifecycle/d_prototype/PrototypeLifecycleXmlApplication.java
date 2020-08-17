package com.linkedbear.spring.lifecycle.d_prototype;

import com.linkedbear.spring.lifecycle.d_prototype.bean.Pen;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PrototypeLifecycleXmlApplication {
    
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("lifecycle/bean-prototype.xml");
        System.out.println("IOC容器初始化完成。。。");
        System.out.println();
        System.out.println("准备获取一个Pen。。。");
        Pen pen = ctx.getBean(Pen.class);
        System.out.println("已经取到了Pen。。。");
        System.out.println();
        System.out.println("用完Pen了，准备销毁。。。");
        ctx.getBeanFactory().destroyBean(pen);
        System.out.println("Pen销毁完成。。。");
        ctx.close();
    }
}
