package com.example.demo.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * springboot 整合 redi是配置
 */

@Configuration
public class RedisConfig {
    /**
     * 1.创建连接对象 jedisConfigPool 完成连接池
     */
    @Bean
    @ConfigurationProperties("spring.redis.pool")
    public JedisPoolConfig jedisPoolConfig() {

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //最大空闲数
//        jedisPoolConfig.setMaxIdle(10);
//        //  最小连接数
//        jedisPoolConfig.setMinIdle(5);
//        // 最大连接数
//        jedisPoolConfig.setMaxTotal(20);

        return jedisPoolConfig;
    }

    /**
     * 配置jedis 连接信息
     *
     * @return
     */
    @Bean
    @ConfigurationProperties("spring.redis")
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig poolonfig) {
        JedisConnectionFactory factory = new JedisConnectionFactory();
//        关联连接池对象
        factory.setPoolConfig(poolonfig);
//        factory.setHostName("123.207.121.40");
//        factory.setPort(6379);
        return factory;
    }

    /**
     * 模板对象
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory factory) {

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        管理连接
        redisTemplate.setConnectionFactory(factory);
//        序列化工具
//        给key 设置序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        给值设置序列化器
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }


}
