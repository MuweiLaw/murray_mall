package com.murray.shiro.config;

import com.murray.model.po.admin.sys.AdminSysUserPo;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.UUID;

/**
 * SessionID生成器
 *
 * @author Murray Law
 * @date 2021/12/3 11:00
 */
public class MurraySessionIdGenerator implements SessionIdGenerator {


    @Override
    public Serializable generateId(Session session) {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = (attrs == null) ? null : attrs.getRequest();
        if (ObjectUtils.isEmpty(httpServletRequest)){
            return 0;
        }
        AdminSysUserPo user = (AdminSysUserPo) httpServletRequest.getAttribute("user");

        Long uid =(user == null) ? 0 : user.getId().longValue();
        UUID uuid = UUID.randomUUID();
        return toStr(uuid.getLeastSignificantBits(), true) + toStr( uid, false) + toStr(uuid.getMostSignificantBits(), true);

    }

    private String toStr(Long lo, boolean addZero) {
        String tmp = Long.toUnsignedString(lo, 32);
        return addZero && tmp.length() != "0000000000000".length() ? "0000000000000".substring(0, "0000000000000".length() - tmp.length()) + tmp : tmp;
    }
}
