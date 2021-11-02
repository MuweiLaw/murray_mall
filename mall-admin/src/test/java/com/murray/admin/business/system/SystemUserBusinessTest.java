package com.murray.admin.business.system;

import com.murray.admin.MallAdminApplicationTests;
import com.murray.model.po.system.SystemUserPo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Murray Law
 * @date 2021/11/2 15:45
 */
public class SystemUserBusinessTest extends MallAdminApplicationTests {
    @Autowired
    SystemUserBusiness systemUserBusiness;

    @Test
    void getPageSystemUser() {
    }

    @Test
    void getById() {
        System.out.println(systemUserBusiness.getById(new SystemUserPo().setId(1)));
    }
}