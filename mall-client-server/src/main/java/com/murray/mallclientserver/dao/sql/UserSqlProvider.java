package com.murray.mallclientserver.dao.sql;

import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {

    public String select(final String userName, final String passWord) {

        String sql = new SQL() {
            {
                SELECT("*");
                FROM("mu_user");
                WHERE("deleted_flag = 1 AND user_name='" + userName + "' AND password= '" + passWord + "'");
//                WHERE("user_name='" + userName + "' AND password= '" + passWord + "'");
            }
        }.toString();
        return sql;
    }

    public String selectById(final Integer userId) {

        String sql = new SQL() {
            {
                SELECT("*");
                FROM("mu_user");
                WHERE("deleted_flag = false  AND id= '" + userId + "'");
            }
        }.toString();
        return sql;
    }

}
