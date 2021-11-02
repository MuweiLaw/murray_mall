package com.murray.admin.business.system;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.murray.commons.service.system.SystemUserService;
import com.murray.model.po.system.SystemUserPo;
import com.murray.model.pojo.system.SystemUserPojo;
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
public class SystemUserBusiness {

    @Autowired
    private SystemUserService systemUserService;



    public IPage<SystemUserPojo> getPageSystemUser(IPage<SystemUserPojo> queryMap) {
        return systemUserService.getPageSystemUser(queryMap);
    }

    public SystemUserPo getById(SystemUserPo systemUserPo) {
        return systemUserService.getById(systemUserPo);
    }

}

      