package com.murray.model.po.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统用户资料
 *
 * @author Murray
 */
@Data
@Accessors(chain = true)
@TableName("t_system_user")
public class SystemUserPo implements Serializable {

    private static final long serialVersionUID = -1595900002524121090L;

    @ApiModelProperty(value = "ID", name = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value="用户名 <param>",name="userId")
    private String userId;
    
    @ApiModelProperty(value="用户昵称 <param>",name="nickName")
    private String nickName;
    
    @ApiModelProperty(value="头像 <image>",name="image")
    private String image;
    
    @ApiModelProperty(value="手机号码",name="phone")
    private String phone;
    
    @JsonIgnore
    @ApiModelProperty(value="密码 <hide>",name="password")
    private String password;
    
    @ApiModelProperty(value="类型 :{1:系统管理员,2:运营,3:来宾}  <param>",name="systemUserType")
    private Integer systemUserType;
    
    @ApiModelProperty(value="岗位",name="position")
    private String position;
    
    @ApiModelProperty(value="加密盐",name="passwordSalt")
    @JsonIgnore
    private String passwordSalt;
    
    @ApiModelProperty(value="备注",name="remark")
    private String remark;
    
    @ApiModelProperty(value="版本号",name="version")
    private Long version;
    
    @ApiModelProperty(value="状态 {0:禁用,1:启用} <param>",name="isEnable")
    private Integer isEnable;
    
    @ApiModelProperty(value="创建人",name="createBy")
    private String createBy;
    
    @ApiModelProperty(value="创建时间",name="createTime")
    private Date createTime;
    
    @ApiModelProperty(value="修改人",name="updateBy")
    private String updateBy;
    
    @ApiModelProperty(value="修改时间",name="updateTime")
    private Date updateTime;

    @TableField(exist = false)
    private String pwd;

    @ApiModelProperty(value = "锁版本号", name = "lockVersion")
    private Integer lockVersion;

    @TableField(exist = false)
    private List<Integer> idList;

    @TableField(exist = false)
    private List<Integer> roleArr;

}

      