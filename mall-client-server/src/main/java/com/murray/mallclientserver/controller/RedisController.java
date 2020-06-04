package com.murray.mallclientserver.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.murray.mallclientserver.entity.User;
import com.murray.mallclientserver.util.JsonUtils;


@RestController
@RequestMapping("redis")
public class RedisController {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Value("${spring.redis.password}")
    private String password;

    /**
     * 向redis存入单个字符串
     *
     * @return
     */
    @GetMapping("/test")
    public String redisJsonResult() {
        System.out.println(password);
        redisTemplate.opsForValue().set("user-cache", "wulongwei");
        return redisTemplate.opsForValue().get("user-cache");
    }

    /**
     * 向redis存入一个对象
     *
     * @return
     * @throws IOException
     */
    //@PostMapping("/saveUser")
    @GetMapping("/getUser")
    public User saveUser() throws IOException {
        User user = new User();
        user.setCity("南昌");
        user.setUserAge(22);
        user.setUserSex((short) 1);
        user.setUserName("张三");
//        往redis中存入json
        redisTemplate.opsForValue().set("json:user", JsonUtils.objectToJson(user));
//
        return JsonUtils.jsonToPojo(redisTemplate.opsForValue().get("json:user"), User.class);
    }


}