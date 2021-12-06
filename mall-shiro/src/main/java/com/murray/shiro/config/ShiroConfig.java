package com.murray.shiro.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 * Shiro配置类
 *
 * @author Murray Law
 * @date 2021/12/3 10:55
 */
@Data
@Slf4j
@Configuration
public class ShiroConfig {
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private Integer port;
    @Value("${spring.redis.database}")
    private Integer database;
    @Value("${spring.redis.password}")
    private String redisPassword;
    @Value("${spring.redis.timeout}")
    private Integer timeout;

    /**
     * RedisSessionDAO shiro sessionDao层的实现 通过redis, 使用的是shiro-redis开源插件
     *
     * @return org.crazycake.shiro.RedisSessionDAO
     * @author Murray Law
     * @date 2021/12/3 11:17
     */
    @Bean
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        redisSessionDAO.setSessionIdGenerator(sessionIdGenerator());
        redisSessionDAO.setExpire(60 * 60 * 12);
        return redisSessionDAO;
    }

    /**
     * 配置shiro redisManager, 使用的是shiro-redis开源插件
     *
     * @return org.crazycake.shiro.RedisManager
     * @author Murray Law
     * @date 2021/12/3 11:17
     */
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        String hostPort=host+":"+port;
        log.info("redis:host" + host);
        redisManager.setHost(host);
        redisManager.setTimeout(timeout);
        if (StringUtils.hasLength(redisPassword))
            redisManager.setPassword(redisPassword);

        return redisManager;
    }

    /**
     * Session ID 生成器
     *
     * @return com.murray.shiro.config.MurraySessionIdGenerator
     * @author Murray Law
     * @date 2021/12/3 11:18
     */
    @Bean
    public MurraySessionIdGenerator sessionIdGenerator() {
        return new MurraySessionIdGenerator();
    }

}
