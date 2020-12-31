package com.linkedbear.spring.data.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:data/spring-data-redis.xml")
public class RedisTests {
    
    @Autowired
    RedisTemplate redisTemplate;
    
    @Test
    public void testInsert() {
        redisTemplate.opsForValue().set("name", "I am redis ...");
        redisTemplate.opsForList().rightPushAll("list", "a", "b", "c");
    }
    
    @Test
    public void testGet() {
        System.out.println(redisTemplate.opsForValue().get("name"));
        System.out.println(redisTemplate.opsForList().index("list", 1));
    }
}
