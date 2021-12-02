package com.murray.admin.business.sys;

import com.murray.admin.MallAdminApplicationTests;
import com.murray.model.po.admin.sys.AdminSysUserPo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Murray Law
 * @date 2021/11/2 15:45
 */
public class AdminSysUserBusinessTest extends MallAdminApplicationTests {
    @Autowired
    AdminSysUserBusiness adminUserBusiness;

    @Test
    void getPageSystemUser() {
    }

    @Test
    void getById() {
        System.out.println(adminUserBusiness.getById(new AdminSysUserPo().setId(1)));
    }
}