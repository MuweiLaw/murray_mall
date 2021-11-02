package com.murray.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * "@ComponentScan" 这个注解不加的话, 注入不了commons里的Service
 * @author Murray Law
 * @date 2021/11/2 15:42
 */
@SpringBootApplication
@ComponentScan("com.murray")
@MapperScan(basePackages = {"com.murray.commons.mapper"})
public class MallAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallAdminApplication.class, args);
    }

}
