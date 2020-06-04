package com.murray.mallclientserver.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Data
@ToString
public class User {
    @Id
    private Integer userId;
    private String userName;
    private String passWord;
    private Integer userAge;
    private Short userSex;
    private String city;
}
