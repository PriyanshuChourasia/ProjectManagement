package com.wishalpha.priyanshu.TaskManagementSystem.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.net.URI;

@Configuration
public class RedisConfig {

    @Value("${redis.url}")
    private String redisUrl;

    @Bean
    public JedisPool jedisPool(){
        URI uri = URI.create(redisUrl);
        String host = uri.getHost();
        int port = uri.getPort();
        String userInfo = uri.getUserInfo();
        String password = userInfo.substring(userInfo.indexOf(":")+1);

        return new JedisPool(
                new JedisPoolConfig(),
                host,
                port,
                2000,
                password,
                true
        );
    }

}
