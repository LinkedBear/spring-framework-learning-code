package com.linkedbear.spring.test;

import com.linkedbear.spring.test.bean.Cat;
import com.linkedbear.spring.test.config.SpringTestConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // 或者SpringRunner
@ContextConfiguration(locations = "classpath:test/spring-test.xml")
//@ContextConfiguration(locations = "classpath:test/spring-test.xml", classes = SpringTestConfiguration.class)
public class SpringTests {
    
    @Autowired
    Cat cat;
    
    @Test
    public void testCat() {
        System.out.println(cat);
    }
}
