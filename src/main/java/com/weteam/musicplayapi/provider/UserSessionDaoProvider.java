package com.weteam.musicplayapi.provider;

import com.weteam.musicplayapi.entity.UserSession;
import org.apache.ibatis.jdbc.SQL;

public class UserSessionDaoProvider {

    public String saveUserSession() {

        return new SQL().INSERT_INTO("user_session")
                .VALUES("id", "#{id}")
                .VALUES("user_id", "#{userId}")
                .VALUES("expired_time", "#{expireTime}").toString();
    }

    public String findBySessionId() {

        return new SQL().SELECT("expired_time").FROM("user_session").WHERE("id = #{sessionId}").toString();
    }
}
