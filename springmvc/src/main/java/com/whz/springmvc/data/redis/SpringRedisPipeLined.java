package com.whz.springmvc.data.redis;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

import java.util.List;

/**
 * spring redis pipelined
 *
 * @author whz
 * @date 2020/8/29 17:11
 */
public class SpringRedisPipeLined {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-redis.xml");
        RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);

        long start = System.currentTimeMillis();
        SessionCallback callback = new SessionCallback() {
            @Override
            public Object execute(RedisOperations ops) throws DataAccessException {
                for (int i = 0; i < 100000; i++) {
                    ops.boundValueOps("pipelined_key_" + i).set("pipelined_value_" + i);
                    ops.boundValueOps("pipelined_key_" + i).get();
                }
                return null;
            }
        };

        List results = redisTemplate.executePipelined(callback);
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }
}
