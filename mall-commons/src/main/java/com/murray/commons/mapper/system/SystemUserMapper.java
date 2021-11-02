package com.murray.commons.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.murray.model.po.system.SystemUserPo;
import com.murray.model.pojo.system.SystemUserPojo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Murray
 */
public interface SystemUserMapper extends BaseMapper<SystemUserPo> {

    IPage<SystemUserPojo> getPageSystemUser(IPage<SystemUserPojo> page);

    /**
     * 目前 TokenUntil.getUid()是获取主键ID, 业务需要字段user_id
     *
     * @param id 主键ID,
     * @return java.lang.String
     * @author Murray Law
     * @date 2021/4/12 15:12
     */
    @Select("SELECT `user_id` from t_system_user WHERE id=#{id}")
    String getUserIdByPrimaryKey(@Param("id") String id);

    List<String> getRolesByUserId(@Param("primaryId") String primaryId);
}