package com.murray.model.dto.admin.sys;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 登录
 *
 * @author Murray
 */
@Data
public class LoginDTO implements Serializable {

    private static final long serialVersionUID = -8523787162746092572L;

    @ApiModelProperty(value = "userId", name = "账户")
    private String userId;

    @ApiModelProperty(value = "password", name = "密码")
    private String password;

    @ApiModelProperty(value = "sessionId", name = "系统ID")

    private String sessionId;

    @ApiModelProperty(value = "code", name = "验证码")
    private String code;
}
