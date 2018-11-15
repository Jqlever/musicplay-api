package com.weteam.musicplayapi.provider;

import org.apache.ibatis.jdbc.SQL;

public class UserDaoProvider {

    public String findByEmailAndPwd() {

        return new SQL().SELECT("*").FROM("user").WHERE("email = #{email} and password = #{password}").toString();
    }
}
