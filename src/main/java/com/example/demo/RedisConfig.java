package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

//@Configuration
public class RedisConfig {
  @Bean
  public LettuceConnectionFactory lettuceConnectionFactory() {
    RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration("10.215.116.210", 6379);
    return new LettuceConnectionFactory(redisStandaloneConfiguration);
  }

  @Bean
  RedisTemplate< String, Long > redisTemplate() {
    final RedisTemplate< String, Long > template =  new RedisTemplate< String, Long >();
    template.setConnectionFactory( lettuceConnectionFactory() );
    template.setKeySerializer( new StringRedisSerializer() );
    template.setHashValueSerializer( new GenericToStringSerializer< Long >( Long.class ) );
    template.setValueSerializer( new GenericToStringSerializer< Long >( Long.class ) );
    return template;
  }


}
