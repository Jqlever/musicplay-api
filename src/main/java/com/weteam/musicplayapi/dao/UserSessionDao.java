package com.weteam.musicplayapi.dao;

import com.weteam.musicplayapi.entity.UserSession;
import com.weteam.musicplayapi.provider.UserSessionDaoProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

@Mapper
public interface UserSessionDao {

    @InsertProvider(type = UserSessionDaoProvider.class, method = "saveUserSession")
    int saveUserSession(UserSession userSession);

    @SelectProvider(type = UserSessionDaoProvider.class, method = "findBySessionId")
    UserSession findBySessionId(String sessionId);
}
