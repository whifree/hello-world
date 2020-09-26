package com.whz.springmvc.data.redis.listener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.UnsupportedEncodingException;

/**
 * redis监听
 *
 * @author whz
 * @date 2020/8/29 21:58
 */
public class RedisMessageListener implements MessageListener {

    private RedisTemplate redisTemplate;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 获取消息
        byte[] body = message.getBody();
        // 反序列化消息
        String msg = (String) redisTemplate.getValueSerializer().deserialize(body);
        System.out.println(msg);

        // 获取channel
        byte[] channel = message.getChannel();
        String channelStr = (String) redisTemplate.getDefaultSerializer().deserialize(channel);
        System.out.println(channelStr);

        try {
            System.out.println(new String(pattern, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
