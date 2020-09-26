package com.whz.springmvc;

import redis.clients.jedis.Jedis;

public class RedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.182.128", 6379);
        int i = 0;
        try {
            long start = System.currentTimeMillis();
            while (true) {
                if (System.currentTimeMillis() - start >= 1000) {
                    break;
                }
                i++;
                String key = "test" + i;
                //jedis.set(key, String.valueOf(i));
                //jedis.expire(key, 10);
                jedis.del(key);
            }
        } finally {
            jedis.close();
        }

        System.out.println(i);
    }
}
