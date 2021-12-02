package com.murray.model.pojo.admin.sys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * ClassName: SystemUser
 * Description: 系统用户资料
 *
 * @author: lingsuzhi
 * @version: 1.0
 * @since: JDK 1.8
 */
@Data
@Accessors(chain = true)
public class AdminSysUserPojo implements Serializable {

    private static final long serialVersionUID = -6597411129113617036L;

    @ApiModelProperty(value="",name="id")
    private Integer id;
    
    @ApiModelProperty(value="用户名",name="userId")
    private String userId;
    
    @ApiModelProperty(value="用户昵称",name="nickName")
    private String nickName;
    
    @ApiModelProperty(value="头像",name="image")
    private String image;
    
    @ApiModelProperty(value="手机号码",name="phone")
    private String phone;
    
    @ApiModelProperty(value="密码",name="password")
    @JsonIgnore
    private String password;
    
    @ApiModelProperty(value="类型",name="systemUserType")
    private Integer systemUserType;
    
    @ApiModelProperty(value="岗位",name="position")
    private String position;
    
    @ApiModelProperty(value="加密盐",name="passwordSalt")
    private String passwordSalt;
    
    @ApiModelProperty(value="备注",name="remark")
    private String remark;
    
    @ApiModelProperty(value="版本号",name="version")
    private Long version;
    
    @ApiModelProperty(value="状态",name="isEnable")
    private Integer isEnable;
    
    @ApiModelProperty(value="创建人",name="createBy")
    private String createBy;
    
    @ApiModelProperty(value="创建时间",name="createTime")
    private Date createTime;
    
    @ApiModelProperty(value="修改人",name="updateBy")
    private String updateBy;
    
    @ApiModelProperty(value="修改时间",name="updateTime")
    private Date updateTime;

    @ApiModelProperty(value="角色列表",name="roles")
    private List<String> roles;

}

      