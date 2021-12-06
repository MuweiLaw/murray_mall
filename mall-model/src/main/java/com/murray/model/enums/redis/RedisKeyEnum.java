package com.murray.model.enums.redis;

import lombok.Getter;
import org.springframework.util.Assert;

/**
 * RedisKey枚举
 *
 * @author Murray Law
 * @date 2021/12/3 10:32
 */
@Getter
public enum RedisKeyEnum {
    //验证码
    ADMIN_LOGIN_CODE("mmp", "ADMIN", "LOGINCODE");


    /**
     * 系统标识
     */
    private String keyPrefix;
    /**
     * 模块名称
     */
    private String module;
    /**
     * 方法名称
     */
    private String func;
    /**
     * key
     */
    private String key;


    RedisKeyEnum(String keyPrefix, String module, String func) {
        this.keyPrefix = keyPrefix;
        this.module = module;
        this.func = func;
    }

    RedisKeyEnum(String keyPrefix, String module, String func, String key) {
        this.keyPrefix = keyPrefix;
        this.module = module;
        this.func = func;
        this.key = key;
    }

    public String keyBuilder() {
        return checkAndGetValue(key);
    }

    public String keyBuilder(String key) {
        return checkAndGetValue(key);
    }

    private String checkAndGetValue(String key) {
        Assert.notNull(keyPrefix, "RedisKeyEnum: keyPrefix can not be null");
        Assert.notNull(module, "RedisKeyEnum: module can not be null");
        Assert.notNull(func, "RedisKeyEnum: func can not be null");
        Assert.notNull(key, "RedisKeyEnum: key can not be null");
        return keyPrefix + ":" + module + ":" + func + ":" + key;
    }


}
