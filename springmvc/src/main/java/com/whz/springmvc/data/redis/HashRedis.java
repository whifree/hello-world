package com.whz.springmvc.data.redis;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashRedis {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-redis.xml");
        RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);

        String key = "hash:test";

        Map<String, String> map = new HashMap<>();
        map.put("f1", "val1");
        map.put("f2", "val1");

        // hmset
        redisTemplate.opsForHash().putAll(key, map);

        // hset
        redisTemplate.opsForHash().put(key, "f3", "val3");

        // hexists
        System.out.println(redisTemplate.opsForHash().hasKey(key, "f3"));

        // hget
        System.out.println(redisTemplate.opsForHash().get(key, "f1"));

        // hgetall
        System.out.println(redisTemplate.opsForHash().entries(key));

        // hvals
        System.out.println(redisTemplate.opsForHash().values(key));

        // hkeys
        System.out.println(redisTemplate.opsForHash().keys(key));

        // hdel
        System.out.println(redisTemplate.opsForHash().delete(key, "f3"));

        // hmget
        List<String> fields = new ArrayList<>(1);
        fields.add("f1");
        fields.add("f2");
        System.out.println(redisTemplate.opsForHash().multiGet(key, fields));

        // del
        System.out.println(redisTemplate.delete(key));
    }
}
