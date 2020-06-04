package com.murray.mallclientserver.service.impl;

import java.util.Map;
import java.util.UUID;

import com.murray.mallclientserver.base.BaseApiService;
import com.murray.mallclientserver.base.ResponseBase;
import com.murray.mallclientserver.entity.User;
import com.murray.mallclientserver.dao.UserDao;
import com.murray.mallclientserver.service.UserService;
import com.murray.mallclientserver.util.ProductToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends BaseApiService implements UserService {
    @Autowired
    private ProductToken productToken;
    @Autowired
    private UserDao userDao;


    @Override
    public ResponseBase UserLogin(String userName, String passWord) {
        //1.校验登陆是否成功
        User user = userDao.getUserInfo(userName, passWord);
        //2.如果不成功返回提示
        if (user == null) {
            return setResultError("账户名密码错误！！！");
        } else {
            //3.如果成功，生产一个token
            String token = UUID.randomUUID().toString().replaceAll("-", "");
            Map<String, String> mapInfo = productToken.productToken(user.getUserId().toString(), token);
            //3.返回token信息（有效期50分钟）
            return setResultSuccess((Object) mapInfo);
        }
    }

    @Override
    public ResponseBase getUserInfo(Integer userId) {
        User user = userDao.getUser(userId);
        if (user != null) {
            return setResultSuccess((Object) user);
        } else {
            return setResultSuccess("无此用户");
        }
    }

}
