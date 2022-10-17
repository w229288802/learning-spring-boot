package com.example.demo.app;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisLockUtils {
    private final RedisTemplate redisTemplate;

    public RedisLockUtils(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public RedisLock getLock(String id){
        RedisLock redisLock = new RedisLock(id, redisTemplate);
        return redisLock;
    }
}
