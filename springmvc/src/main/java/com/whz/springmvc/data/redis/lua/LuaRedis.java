package com.whz.springmvc.data.redis.lua;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;

/**
 * 使用lua语言操作redis
 *
 * @author whz
 * @date 2020/8/31 22:32
 */
public class LuaRedis {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-redis.xml");
        RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);

        Jedis jedis = (Jedis) redisTemplate.getConnectionFactory().getConnection().getNativeConnection();

        // 执行简单的lua
        String hello = (String) jedis.eval("return 'hello java'");
        System.out.println(hello);

        // 带参数的脚本
        jedis.eval("redis.call('set', KEYS[1], ARGV[1])", 1, "lua-key", "lua-value");
        String str = jedis.get("lua-key");
        System.out.println(str);

        // 缓存脚本，返回sha1签名
        String sha1 = jedis.scriptLoad("redis.call('set', KEYS[1], ARGV[1])");
        // 通过标识执行脚本
        jedis.evalsha(sha1, 1, new String[]{"sha-key", "sha-value"});
        String s = jedis.get("sha-key");
        System.out.println(s);

        // 关闭连接
        jedis.close();
    }
}
