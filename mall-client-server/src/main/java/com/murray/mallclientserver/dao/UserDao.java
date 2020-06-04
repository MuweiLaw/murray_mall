package com.murray.mallclientserver.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.murray.mallclientserver.entity.User;
import com.murray.mallclientserver.dao.sql.UserSqlProvider;

@Repository
@Mapper
public interface UserDao {

    /**
     * 通过用户名、密码获取用户信息
     *
     * @param userName
     * @param passWord
     * @return
     */
    @SelectProvider(method = "select", type = UserSqlProvider.class)
    @Results(id = "user", value = {
            @Result(column = "id", property = "userId", id = true),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "password", property = "passWord"),
            @Result(column = "user_age", property = "userAge"),
            @Result(column = "user_sex", property = "userSex"),
            @Result(column = "city", property = "city")
    })
    User getUserInfo(String userName, String passWord);

    /**
     * 通过用户ID查询用户基本信息
     *
     * @param userId
     * @return
     */
    @SelectProvider(method = "selectById", type = UserSqlProvider.class)
    @ResultMap(value = "user")
    User getUser(Integer userId);
}
