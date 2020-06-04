package com.murray.mallclientserver.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.murray.mallclientserver.base.ResponseBase;
import com.murray.mallclientserver.entity.dto.UserDto;
import com.murray.mallclientserver.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    /**
     *@Param [userDto, request]
     *@return com.murray.mallclientserver.base.ResponseBase
     *@Description: //TODO 登陆成功返回token给前台，之后每调一个接口都需要校验token之后有效
     *@author Murray Law
     *@date 2019/10/28 15:32
     */
    public ResponseBase UserLogin(@RequestBody @Valid UserDto userDto, HttpServletRequest request) {
        return userService.UserLogin(userDto.getUserName(), userDto.getPassWord());
    }

    @GetMapping("/getUserInfo")
    /**
     *@Param [id]
     *@return com.murray.mallclientserver.base.ResponseBase
     *@Description: //TODO 查看用户的基本信息
     *@author Murray Law
     *@date 2019/10/28 15:31
     */
    public ResponseBase getUserInfo(Integer id) {
        return userService.getUserInfo(id);
    }

}
