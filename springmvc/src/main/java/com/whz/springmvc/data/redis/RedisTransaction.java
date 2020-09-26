package com.whz.springmvc.data.redis;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

/**
 * redis事务
 *
 * @author whz
 * @date 2020/8/29 12:48
 */
public class RedisTransaction {
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-redis.xml");
        RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);

        SessionCallback callback = new SessionCallback() {
            @Override
            public Object execute(RedisOperations ops) throws DataAccessException {
                ops.multi();
                ops.boundValueOps("key1").set("value1");
                String value = (String) ops.boundValueOps("key1").get();
                System.out.println("未执行exec，value=" + value);

                ops.exec();

                value = (String) redisTemplate.opsForValue().get("key1");
                return value;
            }
        };

        String value = (String) redisTemplate.execute(callback);
        System.out.println(value);
    }
}
