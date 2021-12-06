package com.murray.shiro.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 缓存用户信息
 *
 * @author Murray Law
 * @date 2021/12/2 18:35
 */
@Data
@Builder
@Accessors(chain = true)
public class CacheUser implements Serializable {

    private static final long serialVersionUID = -1889724142558171082L;
    @ApiModelProperty(value = "userId", name = "账户")
    private String userId;

    @ApiModelProperty(value = "password", name = "密码")
    private String token;

    @ApiModelProperty(value = "sessionId", name = "系统ID")
    private String sessionId;

    @ApiModelProperty(value = "loginTime", name = "登录时间")
    private Date loginTime;

    @ApiModelProperty(value = "nickName", name = "昵称")
    private String nickName;

    @ApiModelProperty(value = "systemUserType", name = "类型 :{1:系统管理员,2:运营,3:来宾}")
    private Integer systemUserType;

    @ApiModelProperty(value = "image", name = "头像")
    private String image;


    //岗位
    private String position;

    private Integer id;

//    private List<PermissionListVo> permissionListVoList;
}
