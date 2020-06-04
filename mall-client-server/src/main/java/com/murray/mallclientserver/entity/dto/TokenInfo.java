
package com.murray.mallclientserver.entity.dto;

import lombok.Data;
import lombok.ToString;

/*
 * @Description: //TODO 用户登录信息
 * @Author Murray Law
 * @Date 2019/10/28 16:06
 */
@Data
@ToString
public class TokenInfo {

    private String adminId;
    private String token;
}
