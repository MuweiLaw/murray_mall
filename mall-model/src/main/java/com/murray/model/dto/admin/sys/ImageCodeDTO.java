package com.murray.model.dto.admin.sys;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 验证码数据传输对象
 *
 * @author Murray Law
 * @date 2021/12/3 11:56
 */
@Data
public class ImageCodeDTO {

    @ApiModelProperty(value = "image", name = "图片验证码")
    private String image;

    @ApiModelProperty(value = "sessionId", name = "系统ID")
    private String sessionId;

}
