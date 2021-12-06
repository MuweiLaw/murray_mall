package com.murray.shiro.business;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import com.murray.commons.controller.BaseController;
import com.murray.commons.exception.ServiceException;
import com.murray.model.dto.admin.sys.ImageCodeDTO;
import com.murray.model.dto.admin.sys.LoginDTO;
import com.murray.model.enums.redis.RedisKeyEnum;
import com.murray.shiro.bean.CacheUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Properties;

/**
 * 管理系统登录业务层代码
 *
 * @author Murray Law
 * @date 2021/12/2 18:29
 */
@Slf4j
@Service
public class AdminBusiness extends BaseController {

    private String profilesActive;
    private final RedisTemplate<String, String> redisTemplateStr;

    public AdminBusiness(RedisTemplate<String, String> redisTemplateStr) {
        this.redisTemplateStr = redisTemplateStr;
    }

    /**
     * set方法获取启动的环境配置文件
     *
     * @param profilesActive 配置文件活动
     * @author Murray Law
     * @date 2021/12/3 10:25
     */
    @Value("${spring.profiles.active}")
    public void setProfilesActive(String profilesActive) {
        this.profilesActive = profilesActive;
    }

    /**
     * 登录业务
     *
     * @param loginDTO 登录请求数据传输对象
     * @return com.murray.shiro.bean.CacheUser
     * @author Murray Law
     * @date 2021/12/3 10:26
     */
    public CacheUser login(LoginDTO loginDTO) {
        if ("1111".equals(loginDTO.getCode()) && profilesActive.startsWith("dev")) {
            log.info("本地环境，使用1111验证码");
        } else {
            String code = redisTemplateStr.opsForValue().get(RedisKeyEnum.ADMIN_LOGIN_CODE.keyBuilder(loginDTO.getSessionId()));
            if (ObjectUtils.isEmpty(code)) {
                throw new ServiceException("4349", "验证码已过期，请刷新！");
            }
            if (!code.equalsIgnoreCase(loginDTO.getCode())) {
                throw new ServiceException("5349", "验证码错误");
            }
        }
//        try {
//            shiroLoginBusiness.logout();
//        } catch (Exception e) {
//            log.error("退出登录异常", e);
//        }
//        CacheUser cacheUser = shiroLoginBusiness.login(loginDTO.getUserId(), loginDTO.getPassword());
//        //登录日志
//        loginLog(cacheUser);
//        log.info("###登录返回:{}", cacheUser);
        return null;
    }

    public ImageCodeDTO getImageCode(String uuid) {

        DefaultKaptcha producer = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.setProperty("kaptcha.border", "yes");
        properties.setProperty("kaptcha.border.color", "105,179,90");

        properties.setProperty("kaptcha.textproducer.font.color", "blue");
        properties.setProperty("kaptcha.textproducer.font.size", "32");
        properties.setProperty("kaptcha.image.width", "100");
        properties.setProperty("kaptcha.image.height", "38");
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");

        Config config = new Config(properties);
        producer.setConfig(config);
        String code = producer.createText();

        log.info("getImageCode 验证码  : {}", code);
        BufferedImage bi = producer.createImage(code);

        ImageCodeDTO result = new ImageCodeDTO();
        result.setSessionId(uuid);
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            ImageIO.write(bi, "jpg", out);

            result.setImage(Base64.encodeBase64String(out.toByteArray()));
            redisTemplateStr.opsForValue().set(RedisKeyEnum.ADMIN_LOGIN_CODE.keyBuilder(uuid), code, 300);
        } catch (Exception e) {
            log.error("getImageCode 生成验证码失败", e);
            throw new ServiceException("2131", "生成验证码失败");
        }
        return result;
    }

}
