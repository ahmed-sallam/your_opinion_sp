package com.techpeak.your_openion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.UUID;

@Configuration
public class RedisConfig {

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
//        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
//        return new JedisConnectionFactory(redisStandaloneConfiguration);
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<Long, Object> redisTemplate() {
        RedisTemplate<Long, Object> template =
                new RedisTemplate<>();
        template.setConnectionFactory(
                jedisConnectionFactory());
//        template.setKeySerializer(
//                new StringRedisSerializer());
//        template.setHashKeySerializer(
//                new StringRedisSerializer());
//        template.setHashKeySerializer(
//                new JdkSerializationRedisSerializer());
//        template.setValueSerializer(
//                new JdkSerializationRedisSerializer());
//        template.setEnableTransactionSupport(true);
//        template.afterPropertiesSet();
        return template;
    }




}
