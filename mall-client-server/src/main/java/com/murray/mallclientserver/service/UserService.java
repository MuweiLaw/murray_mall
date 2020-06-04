package com.murray.mallclientserver.service;

import com.murray.mallclientserver.base.ResponseBase;

public interface UserService {

    /**
     * 用户登录
     *
     * @param userName
     * @param passWord
     * @return
     */
    public ResponseBase UserLogin(String userName, String passWord);

    /**
     * 获取用户基本信息
     *
     * @param userId
     * @return
     */
    public ResponseBase getUserInfo(Integer userId);
}
