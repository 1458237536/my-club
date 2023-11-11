package com.liang.auth.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis 配置
 *
 * @author yzy
 * @date 2023/11/02
 */
@Configuration
public class RedisConfig {

    /**
     * Redis 模板
     * 使用Spring的@Bean注解，将此方法注册为一个Spring Bean，用于配置RedisTemplate
     * @param redisConnectionFactory Redis 连接工厂
     * @return {@code RedisTemplate<String, Object>}
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        // 创建一个RedisTemplate实例，用于与Redis交互
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();

        // 创建一个Redis序列化器，用于序列化和反序列化键（Key）
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();

        // 设置RedisTemplate的连接工厂，以便与Redis服务器建立连接
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        // 设置键的序列化器，以便将键序列化为字符串
        redisTemplate.setKeySerializer(redisSerializer);

        // 设置哈希键的序列化器，通常与键的序列化器相同
        redisTemplate.setHashKeySerializer(redisSerializer);

        // 设置值的序列化器，通常使用Jackson2JsonRedisSerializer将值序列化为JSON格式
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer());

        // 设置哈希值的序列化器，通常使用Jackson2JsonRedisSerializer将值序列化为JSON格式
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer());

        // 返回配置好的RedisTemplate实例
        return redisTemplate;
    }

    /**
     * Jackson2 JSON Redis 序列化程序
     * 创建一个Jackson2JsonRedisSerializer实例，用于将Java对象序列化为JSON格式
     *
     * @return {@code Jackson2JsonRedisSerializer<Object>}
     */
    private Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer() {
        // 创建一个Jackson2JsonRedisSerializer实例，并指定要序列化的对象类型（Object.class）
        Jackson2JsonRedisSerializer<Object> jsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);

        // 创建一个ObjectMapper实例，用于配置JSON序列化和反序列化的行为
        ObjectMapper objectMapper = new ObjectMapper();

        // 配置ObjectMapper，以便处理所有属性的序列化和反序列化，包括私有属性
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);

        // 配置ObjectMapper，以便在反序列化时忽略未知的属性，以防止反序列化失败
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // 配置ObjectMapper，以便启用默认类型信息（类型标识），以支持多态对象的序列化和反序列化
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);

        // 将配置好的ObjectMapper设置到Jackson2JsonRedisSerializer中，以便正确序列化和反序列化对象
        jsonRedisSerializer.setObjectMapper(objectMapper);

        // 返回配置好的Jackson2JsonRedisSerializer实例
        return jsonRedisSerializer;
    }


}
