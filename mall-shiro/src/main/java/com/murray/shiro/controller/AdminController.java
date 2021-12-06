package com.murray.shiro.controller;

import com.murray.commons.ResponseInfo;
import com.murray.shiro.bean.CacheUser;
import com.murray.shiro.business.AdminBusiness;
import com.murray.model.dto.admin.sys.ImageCodeDTO;
import com.murray.model.dto.admin.sys.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 管理后台控制器
 *
 * @author Murray Law
 * @date 2021/12/3 11:53
 */
@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private AdminBusiness adminBusiness;

    /**
     * 登录
     *
     * @param loginDTO 账户密码
     */
    @PostMapping(value = "/login")
    public ResponseInfo<CacheUser> login(@RequestBody LoginDTO loginDTO) {
        return ResponseInfo.assertion(adminBusiness.login(loginDTO));
    }

    /**
     * 获取用户资料
     */
//    @PostMapping(value = "/getCurrentUser")
//    public ResponseInfo<CacheUser> getCurrentUser() {
//        return ResponseInfo.assertion(adminBusiness.getCurrentUser());
//    }

    /**
     * 获取验证码
     */
    @GetMapping("/getImageCode/{uuid}")
    public ResponseInfo<ImageCodeDTO> getImageCode(@PathVariable String uuid) {
        return ResponseInfo.assertion(adminBusiness.getImageCode(uuid));
    }

    /**
     * 登出
     */
//    @RequestMapping("/logout")
//    public ResponseInfo<?> logOut() {
//        adminBusiness.logout();
//        return ResponseInfo.success("登出成功！");
//    }

    /**
     * 修改密码
     *
     * @param changePasswordDTO 账户密码
     * @return 成功返回true
     */
//    @PostMapping(value = "/changePassword")
//    public ResponseInfo<Boolean> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
//        return ResponseInfo.assertion(adminBusiness.changePassword(changePasswordDTO));
//    }


//    @ApiOperation(value = "用户修改自己的密码", notes = "修改", httpMethod = "POST")
//    @PostMapping(value = "/changeOwnPasswordAndLogOut")
//    public ResponseInfo<String> changeOwnPasswordAndLogOut(@RequestBody ChangePasswordDTO changePasswordDTO) {
//        Boolean changePassword = adminBusiness.changePassword(changePasswordDTO);
//        if (changePassword) {
//            adminBusiness.logout();
//            return ResponseInfo.success("成功修改密码，请重新登录！");
//        } else {
//            return ResponseInfo.error("错误");
//        }
//    }
}
