package com.weteam.musicplayapi.dao;

import com.weteam.musicplayapi.entity.User;
import com.weteam.musicplayapi.provider.UserDaoProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

@Mapper
public interface UserDao {

//    @Select("select id, user_name, email, password from user where email = #{email} and password = #{password}")
    @SelectProvider(type = UserDaoProvider.class, method = "findByEmailAndPwd")
    User findByEmailAndPwd(@Param(value = "email") String email, @Param(value = "password") String password);
}
