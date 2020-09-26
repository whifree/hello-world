package com.whz.springmvc.data.redis;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * redis链表操作
 *
 * @author whz
 * @date 2020/8/29 10:26
 */
public class LinkedListRedis {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-redis.xml");
        RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);

        String key = "list";

        redisTemplate.delete(key);

        redisTemplate.opsForList().leftPush(key, "node3");

        List<String> nodeList = new ArrayList<>(2);
        for (int i = 2; i >= 1 ; i--) {
            nodeList.add("node" + i);
        }

        redisTemplate.opsForList().leftPushAll(key, nodeList);

        redisTemplate.opsForList().rightPush(key, "node4");

        // 获取下标为0的节点
        String node1 = (String) redisTemplate.opsForList().index(key, 0);

        Long size = redisTemplate.opsForList().size(key);

        List<String> nodes = redisTemplate.opsForList().range(key, 0, 10);
        System.out.println(nodes);

        redisTemplate.delete(key);
    }
}
