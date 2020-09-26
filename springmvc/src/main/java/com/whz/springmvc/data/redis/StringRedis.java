package com.whz.springmvc.data.redis;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class StringRedis {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-redis.xml");
        RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);

        // 设置值
        redisTemplate.opsForValue().set("key1", "value1");
        redisTemplate.opsForValue().set("key2", "value2");

        // 获取值
        System.out.println(redisTemplate.opsForValue().get("key2"));

        // 删除值
        System.out.println(redisTemplate.delete("key2"));

        // 设置新值返回旧值
        System.out.println(redisTemplate.opsForValue().getAndSet("key1", "value3"));

        System.out.println(redisTemplate.delete("key1"));
    }
}
