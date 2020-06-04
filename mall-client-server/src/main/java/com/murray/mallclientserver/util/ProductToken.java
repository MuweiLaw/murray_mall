package com.murray.mallclientserver.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 生产token,如果同一用户重复登录，token的时效重置
 *
 * @author ASUS
 */
@Service
public class ProductToken {

    /**
     * @param key
     * @param value
     * @return Map<>
     * @Description: 生成有时效的token 之后调其他接口需要校验adminId和token值
     * @author Murray Law
     * @date 2019/10/25 14:57
     */
    public Map<String, String> productToken(String key, String value) {
        Map<String, String> infoMap = new HashMap<String, String>();
        if (redisTemplate.opsForValue().get(key) == null) {
            //将登陆的信息保存入redis
            redisTemplate.opsForValue().set(key, value);
            infoMap.put(key, value);
        }
        //设置token有效的时间
        redisTemplate.expire(key, 300, TimeUnit.SECONDS);
        return infoMap;
    }

    @Autowired
    private StringRedisTemplate redisTemplate;

}
