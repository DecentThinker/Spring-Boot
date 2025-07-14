package com.example.SpringRedis.util;

import com.example.SpringRedis.config.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil
{
    @Autowired
    RedisTemplate<String,User> redisTemplate;

    public void setExpirablekey(String key, User value, long time)
    {
         redisTemplate.opsForValue().set(key,value,time, TimeUnit.SECONDS);
    }

    public void setNonExpirableKey(String key, User value)
    {
        redisTemplate.opsForValue().set(key, value);
    }

    public User getDataFromRedis(String key)
    {
        return redisTemplate.opsForValue().get(key);
    }
}
