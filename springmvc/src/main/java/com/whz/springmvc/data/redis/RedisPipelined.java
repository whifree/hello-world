package com.whz.springmvc.data.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.util.List;

/**
 * 流水线
 *
 * @author whz
 * @date 2020/8/29 16:42
 */
public class RedisPipelined {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.182.128", 6379);
        long start = System.currentTimeMillis();

        Pipeline pipelined = jedis.pipelined();
        for (int i = 0; i < 100000; i++) {
            pipelined.set("pipelined_key_" + i, "pipelined_value_" + i);
            pipelined.get("pipelined_key_" + i);
        }

        List result = pipelined.syncAndReturnAll();

        System.out.println("耗时：" + (System.currentTimeMillis() - start));

        /*for (Object object : result) {
            System.out.println((String) object);
        }*/
    }
}
