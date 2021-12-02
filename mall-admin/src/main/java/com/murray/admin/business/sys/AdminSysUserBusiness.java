package com.murray.admin.business.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.murray.commons.service.admin.system.AdminSysUserService;
import com.murray.model.po.admin.sys.AdminSysUserPo;
import com.murray.model.pojo.admin.sys.AdminSysUserPojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: SystemUserBusiness
 * Description: 系统用户资料 业务层
 *
 * @author Murray
 */
@Service
@Slf4j
public class AdminSysUserBusiness {

    @Autowired
    private AdminSysUserService adminSysUserService;



    public IPage<AdminSysUserPojo> getPageSystemUser(IPage<AdminSysUserPojo> queryMap) {
        return adminSysUserService.getPageSystemUser(queryMap);
    }

    public AdminSysUserPo getById(AdminSysUserPo systemUserPo) {
        return adminSysUserService.getById(systemUserPo);
    }

}

      