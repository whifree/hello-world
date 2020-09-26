package com.whz.springmvc.data.redis.listener;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * redis监听测试
 *
 * @author whz
 * @date 2020/8/29 22:30
 */
public class MainTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-redis.xml");
        RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);

        String channel = "chat";
        redisTemplate.convertAndSend(channel, "i am lazy!");
    }
}
