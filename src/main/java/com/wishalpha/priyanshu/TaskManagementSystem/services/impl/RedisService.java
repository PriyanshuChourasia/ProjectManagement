package com.wishalpha.priyanshu.TaskManagementSystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisService {

    private final JedisPool jedisPool;

    @Autowired
    public RedisService(JedisPool jedisPool){
        this.jedisPool = jedisPool;
    }

    public void setValue(String key, String value){
        try(Jedis jedis = jedisPool.getResource()){
            jedis.set(key,value);
        }
    }

    public void setKeyWithTTl(String key, String value, long seconds){
        try(Jedis jedis = jedisPool.getResource()){
            jedis.setex(key,seconds,value);
        }
    }

    public String getValue(String key){
        try(Jedis jedis = jedisPool.getResource()){
            return jedis.get(key);
        }
    }

    public void deleteKey(String key){
        try(Jedis jedis = jedisPool.getResource()){
            jedis.del(key);
        }
    }
}
