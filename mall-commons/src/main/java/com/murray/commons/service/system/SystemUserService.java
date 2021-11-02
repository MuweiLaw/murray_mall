package com.murray.commons.service.system;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.murray.commons.mapper.system.SystemUserMapper;
import com.murray.model.po.system.SystemUserPo;
import com.murray.model.pojo.system.SystemUserPojo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 系统用户资料 服务实现类
 *
 * @author Murray
 */
@Service
public class SystemUserService extends ServiceImpl<SystemUserMapper, SystemUserPo> {

    public IPage<SystemUserPojo> getPageSystemUser(IPage<SystemUserPojo> queryMap) {
        return baseMapper.getPageSystemUser(queryMap);
    }

    /**
     * 目前 TokenUntil.getUid()是获取主键ID, 业务需要字段user_id
     *
     * @param id 主键ID,
     * @return java.lang.String
     * @author Murray Law
     * @date 2021/4/12 15:12
     */
    @Cacheable(cacheNames = "getUserIdByPrimaryKey", key = "#id")
    public String getUserIdByPrimaryKey(String id) {
        return baseMapper.getUserIdByPrimaryKey(id);
    }
}

      